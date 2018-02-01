package com.ws.dingdingcontacts.user;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ws.dingdingcontacts.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableHeaderAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import okhttp3.MediaType;


public class ContractsActivity extends AppCompatActivity {

    public static final String url = "http://219.153.49.6:15982/mauth/a/sys/out/getUsers";
    private IndexableLayout mIndexableLayout;
    private ContactAdapter mAdapter;
    private MenuHeaderAdapter mMenuHeaderAdapter;
    private List<UserEntity> mList = new ArrayList<>();
    Map<String, String> mMap = new HashMap<>(); //用来存放id和name


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contracts);

        //初始化控件
        mIndexableLayout = (IndexableLayout) findViewById(R.id.ilRecyclerview);


        //快排 MODE_FAST
        mIndexableLayout.setCompareMode(IndexableLayout.MODE_FAST);
        //sidebar设置颜色
        mIndexableLayout.setOverlayStyle_MaterialDesign(Color.parseColor("#279df9"));


        //初始化adapter，给rv设置数据
        mAdapter = new ContactAdapter(this, mList);
        mIndexableLayout.setLayoutManager(new LinearLayoutManager(this));
        mIndexableLayout.setAdapter(mAdapter);

        //给adapter设置数据
        mAdapter.setDatas(mList);

        //请求数据
        initData();


        //初始化菜单adapter
        mMenuHeaderAdapter = new MenuHeaderAdapter("↑", null, initMenuDatas());
        mIndexableLayout.addHeaderAdapter(mMenuHeaderAdapter);
        mMenuHeaderAdapter.setOnItemHeaderClickListener(new IndexableHeaderAdapter.OnItemHeaderClickListener<MenuEntity>() {
            @Override
            public void onItemClick(View v, int currentPosition, MenuEntity entity) {
                Toast.makeText(ContractsActivity.this, entity.getMenuTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        mAdapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<UserEntity>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, UserEntity entity) {
                Toast.makeText(ContractsActivity.this, "选中:" + entity.getNick() + "  当前位置:" + currentPosition + "  原始所在数组位置:" + originalPosition, Toast.LENGTH_SHORT).show();
                CheckBox checkBox = (CheckBox) v.getTag();
                checkBox.performClick();
                mAdapter.toggleChecked(originalPosition);

                //选中的时候将id和name存放，未选中移除
                if (checkBox.isChecked()){
                    mMap.put(entity.getId(), entity.getNick());
                }else {
                    mMap.remove(entity.getId());
                }
            }
        });

    }

    /**
     * 请求数据  如果没有显示数据 是因为token过期 调用自己的接口即可
     */
    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("token", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5NWFhZDY2NmJmOGE0Mzg2OTVmNTFkZDk1MGY5MDJmMyIsImlhdCI6MTUxNzQ0NzYzOSwic3ViIjoiIiwiaXNzIjoiIiwiZXhwIjoxNTE3NDY5MjM5fQ.yIvpgE4lNDew5DE26qwj5xgHfTe7NJQ36JoIZ6qsARc");
        map.put("user_id", "95aad666bf8a438695f51dd950f902f3");
        map.put("company_id", "41769573d13a4935aa4515b5de470432");
        OkHttpUtils.postString().url(url).content(new Gson().toJson(map))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if (!TextUtils.isEmpty(response)) {
                            BookBean bookBean = new Gson().fromJson(response, BookBean.class);
                            if (bookBean.getRespCode() == 1) {
                                List<BookBean.DataBean.UserListBean> userList = bookBean.getData().getUserList();
                                for (int i = 0; i < userList.size(); i++) {
                                    mList.add(new UserEntity(userList.get(i).getName(), userList.get(i).getId()));
                                }

                                mAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });

    }

    //添加菜单数据
    private List<MenuEntity> initMenuDatas() {
        List<MenuEntity> list = new ArrayList<>();
        list.add(new MenuEntity("新的朋友", R.mipmap.icon_1));
        list.add(new MenuEntity("群聊", R.mipmap.icon_2));
        return list;
    }

    //菜单adapter
    class MenuHeaderAdapter extends IndexableHeaderAdapter<MenuEntity> {
        private static final int TYPE = 1;

        public MenuHeaderAdapter(String index, String indexTitle, List<MenuEntity> datas) {
            super(index, indexTitle, datas);
        }

        @Override
        public int getItemViewType() {
            return TYPE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
            return new VH(LayoutInflater.from(ContractsActivity.this).inflate(R.layout.header_contact_menu, parent, false));
        }

        @Override
        public void onBindContentViewHolder(RecyclerView.ViewHolder holder, MenuEntity entity) {
            VH vh = (VH) holder;
            vh.tv.setText(entity.getMenuTitle());
            vh.img.setImageResource(entity.getMenuIconRes());
        }

        private class VH extends RecyclerView.ViewHolder {
            private TextView tv;
            private ImageView img;

            public VH(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv_title);
                img = (ImageView) itemView.findViewById(R.id.img);
            }
        }
    }
}
