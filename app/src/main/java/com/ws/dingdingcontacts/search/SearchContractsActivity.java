package com.ws.dingdingcontacts.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.tinypinyin.lexicons.android.cncity.CnCityDict;
import com.google.gson.Gson;
import com.ws.dingdingcontacts.R;
import com.ws.dingdingcontacts.user.BookBean;
import com.ws.dingdingcontacts.user.ContractsActivity;
import com.ws.dingdingcontacts.user.UserEntity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.yokeyword.indexablerv.EntityWrapper;
import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import me.yokeyword.indexablerv.SimpleHeaderAdapter;
import okhttp3.MediaType;

public class SearchContractsActivity extends AppCompatActivity {

    public static final String url = "http://219.153.49.6:15982/mauth/a/sys/out/getUsers"; //替换自己的url地址
    private SearchFragment mSearchFragment;
    private SearchView mSearchView;
    private IndexableLayout mIndexableLayout;
    private List<SearchBean> mList = new ArrayList<>();
    private SearchAdapter mAdapter;
    private SimpleHeaderAdapter mSimpleHeaderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contracts);

        mSearchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.search_fragment);
        mIndexableLayout = (IndexableLayout) findViewById(R.id.indexableLayout);
        mSearchView = (SearchView) findViewById(R.id.searchview);

        mIndexableLayout.setLayoutManager(new LinearLayoutManager(this));

        // 多音字处理
        Pinyin.init(Pinyin.newConfig().with(CnCityDict.getInstance(this)));
        mIndexableLayout.setCompareMode(IndexableLayout.MODE_FAST);


        mAdapter = new SearchAdapter(this);
        mIndexableLayout.setAdapter(mAdapter);


        mAdapter.setDatas(mList, new IndexableAdapter.IndexCallback<SearchBean>() {
            @Override
            public void onFinished(List<EntityWrapper<SearchBean>> datas) {
                mSearchFragment.bindDatas(mList);
            }
        });

        initData();
        mIndexableLayout.setOverlayStyle_Center(); //右侧a-z中间显示

        mAdapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<SearchBean>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, SearchBean entity) {
                Toast.makeText(SearchContractsActivity.this, "选中:" + entity.getName() + "  当前位置:" + currentPosition + "  原始所在数组位置:" + originalPosition, Toast.LENGTH_SHORT).show();
            }
        });

        //第二个参数可以传空，表示没有当前没有悬浮窗
        mSimpleHeaderAdapter = new SimpleHeaderAdapter<>(mAdapter, "☆", "我关心的", initFavDatas());
        mIndexableLayout.addHeaderAdapter(mSimpleHeaderAdapter);

        //搜索
        initSearch();
    }

    private List<SearchBean> initFavDatas() {
        List<SearchBean> list = new ArrayList<>();
        list.add(new SearchBean("小红", "10000"));
        list.add(new SearchBean("小明", "10001"));
        list.add(new SearchBean("小红", "10000"));
        list.add(new SearchBean("小明", "10001"));
        return list;
    }

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
                                    mList.add(new SearchBean(userList.get(i).getName(), userList.get(i).getId()));
                                }

                                mAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });

    }

    private void initSearch() {
        getSupportFragmentManager().beginTransaction().hide(mSearchFragment).commit();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.trim().length() > 0) {
                    if (mSearchFragment.isHidden()) {
                        getSupportFragmentManager().beginTransaction().show(mSearchFragment).commit();
                    }
                } else {
                    if (!mSearchFragment.isHidden()) {
                        getSupportFragmentManager().beginTransaction().hide(mSearchFragment).commit();
                    }
                }

                mSearchFragment.bindQueryText(newText);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!mSearchFragment.isHidden()) {
            // 隐藏 搜索
            mSearchView.setQuery(null, false);
            getSupportFragmentManager().beginTransaction().hide(mSearchFragment).commit();
            return;
        }
        super.onBackPressed();
    }
}
