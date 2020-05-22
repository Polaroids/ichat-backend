package org.buaa.ichat.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author 
*/
public class User implements Serializable {

    private static final long serialVersionUID = 1590137741210L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 
    * isNullAble:0
    */
    private String username;

    /**
    * 
    * isNullAble:0
    */
    @JsonIgnore
    private String password;

    /**
    * 
    * isNullAble:1
    */
    private Integer age;

    /**
    * 
    * isNullAble:1
    */
    private String info;

    /**
    * 
    * isNullAble:0,defaultVal:0
    */
    private Integer sex;

    /**
    * 
    * isNullAble:0
    */
    private String avatar;

    /**
    * 
    * isNullAble:1
    */
    @JsonIgnore
    private String createTime;

    /**
    * 主键
    * 
    * isNullAble:0
    */
    private String email;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setUsername(String username){this.username = username;}

    public String getUsername(){return this.username;}

    public void setPassword(String password){this.password = password;}

    public String getPassword(){return this.password;}

    public void setAge(Integer age){this.age = age;}

    public Integer getAge(){return this.age;}

    public void setInfo(String info){this.info = info;}

    public String getInfo(){return this.info;}

    public void setSex(Integer sex){this.sex = sex;}

    public Integer getSex(){return this.sex;}

    public void setAvatar(String avatar){this.avatar = avatar;}

    public String getAvatar(){return this.avatar;}

    public void setCreateTime(String createTime){this.createTime = createTime;}

    public String getCreateTime(){return this.createTime;}

    public void setEmail(String email){this.email = email;}

    public String getEmail(){return this.email;}
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "username='" + username + '\'' +
                "password='" + password + '\'' +
                "age='" + age + '\'' +
                "info='" + info + '\'' +
                "sex='" + sex + '\'' +
                "avatar='" + avatar + '\'' +
                "createTime='" + createTime + '\'' +
                "email='" + email + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private User set;

        private ConditionBuilder where;

        public UpdateBuilder set(User set){
            this.set = set;
            return this;
        }

        public User getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends User{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> usernameList;

        public List<String> getUsernameList(){return this.usernameList;}


        private List<String> fuzzyUsername;

        public List<String> getFuzzyUsername(){return this.fuzzyUsername;}

        private List<String> rightFuzzyUsername;

        public List<String> getRightFuzzyUsername(){return this.rightFuzzyUsername;}
        private List<String> passwordList;

        public List<String> getPasswordList(){return this.passwordList;}


        private List<String> fuzzyPassword;

        public List<String> getFuzzyPassword(){return this.fuzzyPassword;}

        private List<String> rightFuzzyPassword;

        public List<String> getRightFuzzyPassword(){return this.rightFuzzyPassword;}
        private List<Integer> ageList;

        public List<Integer> getAgeList(){return this.ageList;}

        private Integer ageSt;

        private Integer ageEd;

        public Integer getAgeSt(){return this.ageSt;}

        public Integer getAgeEd(){return this.ageEd;}

        private List<String> infoList;

        public List<String> getInfoList(){return this.infoList;}


        private List<String> fuzzyInfo;

        public List<String> getFuzzyInfo(){return this.fuzzyInfo;}

        private List<String> rightFuzzyInfo;

        public List<String> getRightFuzzyInfo(){return this.rightFuzzyInfo;}
        private List<Integer> sexList;

        public List<Integer> getSexList(){return this.sexList;}

        private Integer sexSt;

        private Integer sexEd;

        public Integer getSexSt(){return this.sexSt;}

        public Integer getSexEd(){return this.sexEd;}

        private List<String> avatarList;

        public List<String> getAvatarList(){return this.avatarList;}


        private List<String> fuzzyAvatar;

        public List<String> getFuzzyAvatar(){return this.fuzzyAvatar;}

        private List<String> rightFuzzyAvatar;

        public List<String> getRightFuzzyAvatar(){return this.rightFuzzyAvatar;}
        private List<String> createTimeList;

        public List<String> getCreateTimeList(){return this.createTimeList;}


        private List<String> fuzzyCreateTime;

        public List<String> getFuzzyCreateTime(){return this.fuzzyCreateTime;}

        private List<String> rightFuzzyCreateTime;

        public List<String> getRightFuzzyCreateTime(){return this.rightFuzzyCreateTime;}
        private List<String> emailList;

        public List<String> getEmailList(){return this.emailList;}


        private List<String> fuzzyEmail;

        public List<String> getFuzzyEmail(){return this.fuzzyEmail;}

        private List<String> rightFuzzyEmail;

        public List<String> getRightFuzzyEmail(){return this.rightFuzzyEmail;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Integer id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder fuzzyUsername (List<String> fuzzyUsername){
            this.fuzzyUsername = fuzzyUsername;
            return this;
        }

        public QueryBuilder fuzzyUsername (String ... fuzzyUsername){
            this.fuzzyUsername = solveNullList(fuzzyUsername);
            return this;
        }

        public QueryBuilder rightFuzzyUsername (List<String> rightFuzzyUsername){
            this.rightFuzzyUsername = rightFuzzyUsername;
            return this;
        }

        public QueryBuilder rightFuzzyUsername (String ... rightFuzzyUsername){
            this.rightFuzzyUsername = solveNullList(rightFuzzyUsername);
            return this;
        }

        public QueryBuilder username(String username){
            setUsername(username);
            return this;
        }

        public QueryBuilder usernameList(String ... username){
            this.usernameList = solveNullList(username);
            return this;
        }

        public QueryBuilder usernameList(List<String> username){
            this.usernameList = username;
            return this;
        }

        public QueryBuilder fetchUsername(){
            setFetchFields("fetchFields","username");
            return this;
        }

        public QueryBuilder excludeUsername(){
            setFetchFields("excludeFields","username");
            return this;
        }

        public QueryBuilder fuzzyPassword (List<String> fuzzyPassword){
            this.fuzzyPassword = fuzzyPassword;
            return this;
        }

        public QueryBuilder fuzzyPassword (String ... fuzzyPassword){
            this.fuzzyPassword = solveNullList(fuzzyPassword);
            return this;
        }

        public QueryBuilder rightFuzzyPassword (List<String> rightFuzzyPassword){
            this.rightFuzzyPassword = rightFuzzyPassword;
            return this;
        }

        public QueryBuilder rightFuzzyPassword (String ... rightFuzzyPassword){
            this.rightFuzzyPassword = solveNullList(rightFuzzyPassword);
            return this;
        }

        public QueryBuilder password(String password){
            setPassword(password);
            return this;
        }

        public QueryBuilder passwordList(String ... password){
            this.passwordList = solveNullList(password);
            return this;
        }

        public QueryBuilder passwordList(List<String> password){
            this.passwordList = password;
            return this;
        }

        public QueryBuilder fetchPassword(){
            setFetchFields("fetchFields","password");
            return this;
        }

        public QueryBuilder excludePassword(){
            setFetchFields("excludeFields","password");
            return this;
        }

        public QueryBuilder ageBetWeen(Integer ageSt,Integer ageEd){
            this.ageSt = ageSt;
            this.ageEd = ageEd;
            return this;
        }

        public QueryBuilder ageGreaterEqThan(Integer ageSt){
            this.ageSt = ageSt;
            return this;
        }
        public QueryBuilder ageLessEqThan(Integer ageEd){
            this.ageEd = ageEd;
            return this;
        }


        public QueryBuilder age(Integer age){
            setAge(age);
            return this;
        }

        public QueryBuilder ageList(Integer ... age){
            this.ageList = solveNullList(age);
            return this;
        }

        public QueryBuilder ageList(List<Integer> age){
            this.ageList = age;
            return this;
        }

        public QueryBuilder fetchAge(){
            setFetchFields("fetchFields","age");
            return this;
        }

        public QueryBuilder excludeAge(){
            setFetchFields("excludeFields","age");
            return this;
        }

        public QueryBuilder fuzzyInfo (List<String> fuzzyInfo){
            this.fuzzyInfo = fuzzyInfo;
            return this;
        }

        public QueryBuilder fuzzyInfo (String ... fuzzyInfo){
            this.fuzzyInfo = solveNullList(fuzzyInfo);
            return this;
        }

        public QueryBuilder rightFuzzyInfo (List<String> rightFuzzyInfo){
            this.rightFuzzyInfo = rightFuzzyInfo;
            return this;
        }

        public QueryBuilder rightFuzzyInfo (String ... rightFuzzyInfo){
            this.rightFuzzyInfo = solveNullList(rightFuzzyInfo);
            return this;
        }

        public QueryBuilder info(String info){
            setInfo(info);
            return this;
        }

        public QueryBuilder infoList(String ... info){
            this.infoList = solveNullList(info);
            return this;
        }

        public QueryBuilder infoList(List<String> info){
            this.infoList = info;
            return this;
        }

        public QueryBuilder fetchInfo(){
            setFetchFields("fetchFields","info");
            return this;
        }

        public QueryBuilder excludeInfo(){
            setFetchFields("excludeFields","info");
            return this;
        }

        public QueryBuilder sexBetWeen(Integer sexSt,Integer sexEd){
            this.sexSt = sexSt;
            this.sexEd = sexEd;
            return this;
        }

        public QueryBuilder sexGreaterEqThan(Integer sexSt){
            this.sexSt = sexSt;
            return this;
        }
        public QueryBuilder sexLessEqThan(Integer sexEd){
            this.sexEd = sexEd;
            return this;
        }


        public QueryBuilder sex(Integer sex){
            setSex(sex);
            return this;
        }

        public QueryBuilder sexList(Integer ... sex){
            this.sexList = solveNullList(sex);
            return this;
        }

        public QueryBuilder sexList(List<Integer> sex){
            this.sexList = sex;
            return this;
        }

        public QueryBuilder fetchSex(){
            setFetchFields("fetchFields","sex");
            return this;
        }

        public QueryBuilder excludeSex(){
            setFetchFields("excludeFields","sex");
            return this;
        }

        public QueryBuilder fuzzyAvatar (List<String> fuzzyAvatar){
            this.fuzzyAvatar = fuzzyAvatar;
            return this;
        }

        public QueryBuilder fuzzyAvatar (String ... fuzzyAvatar){
            this.fuzzyAvatar = solveNullList(fuzzyAvatar);
            return this;
        }

        public QueryBuilder rightFuzzyAvatar (List<String> rightFuzzyAvatar){
            this.rightFuzzyAvatar = rightFuzzyAvatar;
            return this;
        }

        public QueryBuilder rightFuzzyAvatar (String ... rightFuzzyAvatar){
            this.rightFuzzyAvatar = solveNullList(rightFuzzyAvatar);
            return this;
        }

        public QueryBuilder avatar(String avatar){
            setAvatar(avatar);
            return this;
        }

        public QueryBuilder avatarList(String ... avatar){
            this.avatarList = solveNullList(avatar);
            return this;
        }

        public QueryBuilder avatarList(List<String> avatar){
            this.avatarList = avatar;
            return this;
        }

        public QueryBuilder fetchAvatar(){
            setFetchFields("fetchFields","avatar");
            return this;
        }

        public QueryBuilder excludeAvatar(){
            setFetchFields("excludeFields","avatar");
            return this;
        }

        public QueryBuilder fuzzyCreateTime (List<String> fuzzyCreateTime){
            this.fuzzyCreateTime = fuzzyCreateTime;
            return this;
        }

        public QueryBuilder fuzzyCreateTime (String ... fuzzyCreateTime){
            this.fuzzyCreateTime = solveNullList(fuzzyCreateTime);
            return this;
        }

        public QueryBuilder rightFuzzyCreateTime (List<String> rightFuzzyCreateTime){
            this.rightFuzzyCreateTime = rightFuzzyCreateTime;
            return this;
        }

        public QueryBuilder rightFuzzyCreateTime (String ... rightFuzzyCreateTime){
            this.rightFuzzyCreateTime = solveNullList(rightFuzzyCreateTime);
            return this;
        }

        public QueryBuilder createTime(String createTime){
            setCreateTime(createTime);
            return this;
        }

        public QueryBuilder createTimeList(String ... createTime){
            this.createTimeList = solveNullList(createTime);
            return this;
        }

        public QueryBuilder createTimeList(List<String> createTime){
            this.createTimeList = createTime;
            return this;
        }

        public QueryBuilder fetchCreateTime(){
            setFetchFields("fetchFields","createTime");
            return this;
        }

        public QueryBuilder excludeCreateTime(){
            setFetchFields("excludeFields","createTime");
            return this;
        }

        public QueryBuilder fuzzyEmail (List<String> fuzzyEmail){
            this.fuzzyEmail = fuzzyEmail;
            return this;
        }

        public QueryBuilder fuzzyEmail (String ... fuzzyEmail){
            this.fuzzyEmail = solveNullList(fuzzyEmail);
            return this;
        }

        public QueryBuilder rightFuzzyEmail (List<String> rightFuzzyEmail){
            this.rightFuzzyEmail = rightFuzzyEmail;
            return this;
        }

        public QueryBuilder rightFuzzyEmail (String ... rightFuzzyEmail){
            this.rightFuzzyEmail = solveNullList(rightFuzzyEmail);
            return this;
        }

        public QueryBuilder email(String email){
            setEmail(email);
            return this;
        }

        public QueryBuilder emailList(String ... email){
            this.emailList = solveNullList(email);
            return this;
        }

        public QueryBuilder emailList(List<String> email){
            this.emailList = email;
            return this;
        }

        public QueryBuilder fetchEmail(){
            setFetchFields("fetchFields","email");
            return this;
        }

        public QueryBuilder excludeEmail(){
            setFetchFields("excludeFields","email");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public User build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> usernameList;

        public List<String> getUsernameList(){return this.usernameList;}


        private List<String> fuzzyUsername;

        public List<String> getFuzzyUsername(){return this.fuzzyUsername;}

        private List<String> rightFuzzyUsername;

        public List<String> getRightFuzzyUsername(){return this.rightFuzzyUsername;}
        private List<String> passwordList;

        public List<String> getPasswordList(){return this.passwordList;}


        private List<String> fuzzyPassword;

        public List<String> getFuzzyPassword(){return this.fuzzyPassword;}

        private List<String> rightFuzzyPassword;

        public List<String> getRightFuzzyPassword(){return this.rightFuzzyPassword;}
        private List<Integer> ageList;

        public List<Integer> getAgeList(){return this.ageList;}

        private Integer ageSt;

        private Integer ageEd;

        public Integer getAgeSt(){return this.ageSt;}

        public Integer getAgeEd(){return this.ageEd;}

        private List<String> infoList;

        public List<String> getInfoList(){return this.infoList;}


        private List<String> fuzzyInfo;

        public List<String> getFuzzyInfo(){return this.fuzzyInfo;}

        private List<String> rightFuzzyInfo;

        public List<String> getRightFuzzyInfo(){return this.rightFuzzyInfo;}
        private List<Integer> sexList;

        public List<Integer> getSexList(){return this.sexList;}

        private Integer sexSt;

        private Integer sexEd;

        public Integer getSexSt(){return this.sexSt;}

        public Integer getSexEd(){return this.sexEd;}

        private List<String> avatarList;

        public List<String> getAvatarList(){return this.avatarList;}


        private List<String> fuzzyAvatar;

        public List<String> getFuzzyAvatar(){return this.fuzzyAvatar;}

        private List<String> rightFuzzyAvatar;

        public List<String> getRightFuzzyAvatar(){return this.rightFuzzyAvatar;}
        private List<String> createTimeList;

        public List<String> getCreateTimeList(){return this.createTimeList;}


        private List<String> fuzzyCreateTime;

        public List<String> getFuzzyCreateTime(){return this.fuzzyCreateTime;}

        private List<String> rightFuzzyCreateTime;

        public List<String> getRightFuzzyCreateTime(){return this.rightFuzzyCreateTime;}
        private List<String> emailList;

        public List<String> getEmailList(){return this.emailList;}


        private List<String> fuzzyEmail;

        public List<String> getFuzzyEmail(){return this.fuzzyEmail;}

        private List<String> rightFuzzyEmail;

        public List<String> getRightFuzzyEmail(){return this.rightFuzzyEmail;}

        public ConditionBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyUsername (List<String> fuzzyUsername){
            this.fuzzyUsername = fuzzyUsername;
            return this;
        }

        public ConditionBuilder fuzzyUsername (String ... fuzzyUsername){
            this.fuzzyUsername = solveNullList(fuzzyUsername);
            return this;
        }

        public ConditionBuilder rightFuzzyUsername (List<String> rightFuzzyUsername){
            this.rightFuzzyUsername = rightFuzzyUsername;
            return this;
        }

        public ConditionBuilder rightFuzzyUsername (String ... rightFuzzyUsername){
            this.rightFuzzyUsername = solveNullList(rightFuzzyUsername);
            return this;
        }

        public ConditionBuilder usernameList(String ... username){
            this.usernameList = solveNullList(username);
            return this;
        }

        public ConditionBuilder usernameList(List<String> username){
            this.usernameList = username;
            return this;
        }

        public ConditionBuilder fuzzyPassword (List<String> fuzzyPassword){
            this.fuzzyPassword = fuzzyPassword;
            return this;
        }

        public ConditionBuilder fuzzyPassword (String ... fuzzyPassword){
            this.fuzzyPassword = solveNullList(fuzzyPassword);
            return this;
        }

        public ConditionBuilder rightFuzzyPassword (List<String> rightFuzzyPassword){
            this.rightFuzzyPassword = rightFuzzyPassword;
            return this;
        }

        public ConditionBuilder rightFuzzyPassword (String ... rightFuzzyPassword){
            this.rightFuzzyPassword = solveNullList(rightFuzzyPassword);
            return this;
        }

        public ConditionBuilder passwordList(String ... password){
            this.passwordList = solveNullList(password);
            return this;
        }

        public ConditionBuilder passwordList(List<String> password){
            this.passwordList = password;
            return this;
        }

        public ConditionBuilder ageBetWeen(Integer ageSt,Integer ageEd){
            this.ageSt = ageSt;
            this.ageEd = ageEd;
            return this;
        }

        public ConditionBuilder ageGreaterEqThan(Integer ageSt){
            this.ageSt = ageSt;
            return this;
        }
        public ConditionBuilder ageLessEqThan(Integer ageEd){
            this.ageEd = ageEd;
            return this;
        }


        public ConditionBuilder ageList(Integer ... age){
            this.ageList = solveNullList(age);
            return this;
        }

        public ConditionBuilder ageList(List<Integer> age){
            this.ageList = age;
            return this;
        }

        public ConditionBuilder fuzzyInfo (List<String> fuzzyInfo){
            this.fuzzyInfo = fuzzyInfo;
            return this;
        }

        public ConditionBuilder fuzzyInfo (String ... fuzzyInfo){
            this.fuzzyInfo = solveNullList(fuzzyInfo);
            return this;
        }

        public ConditionBuilder rightFuzzyInfo (List<String> rightFuzzyInfo){
            this.rightFuzzyInfo = rightFuzzyInfo;
            return this;
        }

        public ConditionBuilder rightFuzzyInfo (String ... rightFuzzyInfo){
            this.rightFuzzyInfo = solveNullList(rightFuzzyInfo);
            return this;
        }

        public ConditionBuilder infoList(String ... info){
            this.infoList = solveNullList(info);
            return this;
        }

        public ConditionBuilder infoList(List<String> info){
            this.infoList = info;
            return this;
        }

        public ConditionBuilder sexBetWeen(Integer sexSt,Integer sexEd){
            this.sexSt = sexSt;
            this.sexEd = sexEd;
            return this;
        }

        public ConditionBuilder sexGreaterEqThan(Integer sexSt){
            this.sexSt = sexSt;
            return this;
        }
        public ConditionBuilder sexLessEqThan(Integer sexEd){
            this.sexEd = sexEd;
            return this;
        }


        public ConditionBuilder sexList(Integer ... sex){
            this.sexList = solveNullList(sex);
            return this;
        }

        public ConditionBuilder sexList(List<Integer> sex){
            this.sexList = sex;
            return this;
        }

        public ConditionBuilder fuzzyAvatar (List<String> fuzzyAvatar){
            this.fuzzyAvatar = fuzzyAvatar;
            return this;
        }

        public ConditionBuilder fuzzyAvatar (String ... fuzzyAvatar){
            this.fuzzyAvatar = solveNullList(fuzzyAvatar);
            return this;
        }

        public ConditionBuilder rightFuzzyAvatar (List<String> rightFuzzyAvatar){
            this.rightFuzzyAvatar = rightFuzzyAvatar;
            return this;
        }

        public ConditionBuilder rightFuzzyAvatar (String ... rightFuzzyAvatar){
            this.rightFuzzyAvatar = solveNullList(rightFuzzyAvatar);
            return this;
        }

        public ConditionBuilder avatarList(String ... avatar){
            this.avatarList = solveNullList(avatar);
            return this;
        }

        public ConditionBuilder avatarList(List<String> avatar){
            this.avatarList = avatar;
            return this;
        }

        public ConditionBuilder fuzzyCreateTime (List<String> fuzzyCreateTime){
            this.fuzzyCreateTime = fuzzyCreateTime;
            return this;
        }

        public ConditionBuilder fuzzyCreateTime (String ... fuzzyCreateTime){
            this.fuzzyCreateTime = solveNullList(fuzzyCreateTime);
            return this;
        }

        public ConditionBuilder rightFuzzyCreateTime (List<String> rightFuzzyCreateTime){
            this.rightFuzzyCreateTime = rightFuzzyCreateTime;
            return this;
        }

        public ConditionBuilder rightFuzzyCreateTime (String ... rightFuzzyCreateTime){
            this.rightFuzzyCreateTime = solveNullList(rightFuzzyCreateTime);
            return this;
        }

        public ConditionBuilder createTimeList(String ... createTime){
            this.createTimeList = solveNullList(createTime);
            return this;
        }

        public ConditionBuilder createTimeList(List<String> createTime){
            this.createTimeList = createTime;
            return this;
        }

        public ConditionBuilder fuzzyEmail (List<String> fuzzyEmail){
            this.fuzzyEmail = fuzzyEmail;
            return this;
        }

        public ConditionBuilder fuzzyEmail (String ... fuzzyEmail){
            this.fuzzyEmail = solveNullList(fuzzyEmail);
            return this;
        }

        public ConditionBuilder rightFuzzyEmail (List<String> rightFuzzyEmail){
            this.rightFuzzyEmail = rightFuzzyEmail;
            return this;
        }

        public ConditionBuilder rightFuzzyEmail (String ... rightFuzzyEmail){
            this.rightFuzzyEmail = solveNullList(rightFuzzyEmail);
            return this;
        }

        public ConditionBuilder emailList(String ... email){
            this.emailList = solveNullList(email);
            return this;
        }

        public ConditionBuilder emailList(List<String> email){
            this.emailList = email;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private User obj;

        public Builder(){
            this.obj = new User();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder username(String username){
            this.obj.setUsername(username);
            return this;
        }
        public Builder password(String password){
            this.obj.setPassword(password);
            return this;
        }
        public Builder age(Integer age){
            this.obj.setAge(age);
            return this;
        }
        public Builder info(String info){
            this.obj.setInfo(info);
            return this;
        }
        public Builder sex(Integer sex){
            this.obj.setSex(sex);
            return this;
        }
        public Builder avatar(String avatar){
            this.obj.setAvatar(avatar);
            return this;
        }
        public Builder createTime(String createTime){
            this.obj.setCreateTime(createTime);
            return this;
        }
        public Builder email(String email){
            this.obj.setEmail(email);
            return this;
        }
        public User build(){return obj;}
    }

}
