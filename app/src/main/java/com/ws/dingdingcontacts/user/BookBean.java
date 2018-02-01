package com.ws.dingdingcontacts.user;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ws on 2017/12/20.
 */

public class BookBean implements Serializable {

    private int respCode;
    private String message;
    private String timeStamp;
    private DataBean data;

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<UserListBean> userList;

        public List<UserListBean> getUserList() {
            return userList;
        }

        public void setUserList(List<UserListBean> userList) {
            this.userList = userList;
        }

        public static class UserListBean {
            /**
             * id : 0180ff741be54b1d95a2383022a15953
             * isNewRecord : false
             * remarks :
             * createDate : 2017-09-30 15:29:14
             * updateDate : 2017-10-27 14:24:02
             * office : {"id":"4cdc644ef67040279b49cc807822b7d0","isNewRecord":false,"name":"技术开发部","sort":30,"type":"2","istechnology":"no","parentId":"0"}
             * loginName : wanye
             * no : MHBJ017
             * name : 万晔
             * email :
             * phone :
             * mobile : 15600513667
             * userType :
             * loginIp : 123.120.186.46
             * loginDate : 2017-12-06 11:56:37
             * loginFlag : 1
             * oldLoginIp : 123.120.186.46
             * oldLoginDate : 2017-12-06 11:56:37
             * roleList : [{"id":"71b35e432e1e4a68ab672599420ce74b","isNewRecord":false,"remarks":"","office":{"id":"4cdc644ef67040279b49cc807822b7d0","isNewRecord":false,"sort":30,"type":"2","parentId":"0"},"name":"Java工程师","enname":"JavaRD","roleType":"user","dataScope":"1","sysData":"0","useable":"1","companyid":"41769573d13a4935aa4515b5de470432","rolelevel":"1","menuIds":"","officeIds":""},{"id":"2f9720d836c642d0b19e295a05175968","isNewRecord":false,"remarks":"","office":{"id":"4cdc644ef67040279b49cc807822b7d0","isNewRecord":false,"sort":30,"type":"2","parentId":"0"},"name":"管理员","enname":"manager","roleType":"security-role","dataScope":"1","sysData":"1","useable":"1","companyid":"41769573d13a4935aa4515b5de470432","processids":"YZBF:1:81c694bf205541fbbee0ceecd4094eb0","rolelevel":"1","menuIds":"","officeIds":""}]
             * companyid : 41769573d13a4935aa4515b5de470432
             * companyname : 北京满惠网络科技有限公司
             * roleNames : Java工程师,管理员
             * admin : false
             * photo :
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private OfficeBean office;
            private String loginName;
            private String no;
            private String name;
            private String email;
            private String phone;
            private String mobile;
            private String userType;
            private String loginIp;
            private String loginDate;
            private String loginFlag;
            private String oldLoginIp;
            private String oldLoginDate;
            private String companyid;
            private String companyname;
            private String roleNames;
            private boolean admin;
            private String photo;
            private List<RoleListBean> roleList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public OfficeBean getOffice() {
                return office;
            }

            public void setOffice(OfficeBean office) {
                this.office = office;
            }

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
            }

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getLoginIp() {
                return loginIp;
            }

            public void setLoginIp(String loginIp) {
                this.loginIp = loginIp;
            }

            public String getLoginDate() {
                return loginDate;
            }

            public void setLoginDate(String loginDate) {
                this.loginDate = loginDate;
            }

            public String getLoginFlag() {
                return loginFlag;
            }

            public void setLoginFlag(String loginFlag) {
                this.loginFlag = loginFlag;
            }

            public String getOldLoginIp() {
                return oldLoginIp;
            }

            public void setOldLoginIp(String oldLoginIp) {
                this.oldLoginIp = oldLoginIp;
            }

            public String getOldLoginDate() {
                return oldLoginDate;
            }

            public void setOldLoginDate(String oldLoginDate) {
                this.oldLoginDate = oldLoginDate;
            }

            public String getCompanyid() {
                return companyid;
            }

            public void setCompanyid(String companyid) {
                this.companyid = companyid;
            }

            public String getCompanyname() {
                return companyname;
            }

            public void setCompanyname(String companyname) {
                this.companyname = companyname;
            }

            public String getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(String roleNames) {
                this.roleNames = roleNames;
            }

            public boolean isAdmin() {
                return admin;
            }

            public void setAdmin(boolean admin) {
                this.admin = admin;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public List<RoleListBean> getRoleList() {
                return roleList;
            }

            public void setRoleList(List<RoleListBean> roleList) {
                this.roleList = roleList;
            }

            public static class OfficeBean {
                /**
                 * id : 4cdc644ef67040279b49cc807822b7d0
                 * isNewRecord : false
                 * name : 技术开发部
                 * sort : 30
                 * type : 2
                 * istechnology : no
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                private String type;
                private String istechnology;
                private String parentId;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getIstechnology() {
                    return istechnology;
                }

                public void setIstechnology(String istechnology) {
                    this.istechnology = istechnology;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }

            public static class RoleListBean {
                /**
                 * id : 71b35e432e1e4a68ab672599420ce74b
                 * isNewRecord : false
                 * remarks :
                 * office : {"id":"4cdc644ef67040279b49cc807822b7d0","isNewRecord":false,"sort":30,"type":"2","parentId":"0"}
                 * name : Java工程师
                 * enname : JavaRD
                 * roleType : user
                 * dataScope : 1
                 * sysData : 0
                 * useable : 1
                 * companyid : 41769573d13a4935aa4515b5de470432
                 * rolelevel : 1
                 * menuIds :
                 * officeIds :
                 * processids : YZBF:1:81c694bf205541fbbee0ceecd4094eb0
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private OfficeBeanX office;
                private String name;
                private String enname;
                private String roleType;
                private String dataScope;
                private String sysData;
                private String useable;
                private String companyid;
                private String rolelevel;
                private String menuIds;
                private String officeIds;
                private String processids;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public OfficeBeanX getOffice() {
                    return office;
                }

                public void setOffice(OfficeBeanX office) {
                    this.office = office;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getEnname() {
                    return enname;
                }

                public void setEnname(String enname) {
                    this.enname = enname;
                }

                public String getRoleType() {
                    return roleType;
                }

                public void setRoleType(String roleType) {
                    this.roleType = roleType;
                }

                public String getDataScope() {
                    return dataScope;
                }

                public void setDataScope(String dataScope) {
                    this.dataScope = dataScope;
                }

                public String getSysData() {
                    return sysData;
                }

                public void setSysData(String sysData) {
                    this.sysData = sysData;
                }

                public String getUseable() {
                    return useable;
                }

                public void setUseable(String useable) {
                    this.useable = useable;
                }

                public String getCompanyid() {
                    return companyid;
                }

                public void setCompanyid(String companyid) {
                    this.companyid = companyid;
                }

                public String getRolelevel() {
                    return rolelevel;
                }

                public void setRolelevel(String rolelevel) {
                    this.rolelevel = rolelevel;
                }

                public String getMenuIds() {
                    return menuIds;
                }

                public void setMenuIds(String menuIds) {
                    this.menuIds = menuIds;
                }

                public String getOfficeIds() {
                    return officeIds;
                }

                public void setOfficeIds(String officeIds) {
                    this.officeIds = officeIds;
                }

                public String getProcessids() {
                    return processids;
                }

                public void setProcessids(String processids) {
                    this.processids = processids;
                }

                public static class OfficeBeanX {
                    /**
                     * id : 4cdc644ef67040279b49cc807822b7d0
                     * isNewRecord : false
                     * sort : 30
                     * type : 2
                     * parentId : 0
                     */

                    private String id;
                    private boolean isNewRecord;
                    private int sort;
                    private String type;
                    private String parentId;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public int getSort() {
                        return sort;
                    }

                    public void setSort(int sort) {
                        this.sort = sort;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
                    }
                }
            }
        }
    }
}
