package org.buaa.ichat.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author 
*/
public class Friend implements Serializable {

    private static final long serialVersionUID = 1591284243331L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer F_ID;

    /**
    * 
    * isNullAble:0
    */
    private Integer userID;

    /**
    * 
    * isNullAble:0
    */
    private Integer friendID;

    /**
    * 
    * isNullAble:0
    */
    private String time;

    /**
    * 
    * isNullAble:1
    */
    private String name;


    public void setF_ID(Integer F_ID){this.F_ID = F_ID;}

    public Integer getF_ID(){return this.F_ID;}

    public void setUserID(Integer userID){this.userID = userID;}

    public Integer getUserID(){return this.userID;}

    public void setFriendID(Integer friendID){this.friendID = friendID;}

    public Integer getFriendID(){return this.friendID;}

    public void setTime(String time){this.time = time;}

    public String getTime(){return this.time;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}
    @Override
    public String toString() {
        return "Friend{" +
                "F_ID='" + F_ID + '\'' +
                "userID='" + userID + '\'' +
                "friendID='" + friendID + '\'' +
                "time='" + time + '\'' +
                "name='" + name + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Friend set;

        private ConditionBuilder where;

        public UpdateBuilder set(Friend set){
            this.set = set;
            return this;
        }

        public Friend getSet(){
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

    public static class QueryBuilder extends Friend{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> F_IDList;

        public List<Integer> getF_IDList(){return this.F_IDList;}

        private Integer F_IDSt;

        private Integer F_IDEd;

        public Integer getF_IDSt(){return this.F_IDSt;}

        public Integer getF_IDEd(){return this.F_IDEd;}

        private List<Integer> userIDList;

        public List<Integer> getUserIDList(){return this.userIDList;}

        private Integer userIDSt;

        private Integer userIDEd;

        public Integer getUserIDSt(){return this.userIDSt;}

        public Integer getUserIDEd(){return this.userIDEd;}

        private List<Integer> friendIDList;

        public List<Integer> getFriendIDList(){return this.friendIDList;}

        private Integer friendIDSt;

        private Integer friendIDEd;

        public Integer getFriendIDSt(){return this.friendIDSt;}

        public Integer getFriendIDEd(){return this.friendIDEd;}

        private List<String> timeList;

        public List<String> getTimeList(){return this.timeList;}


        private List<String> fuzzyTime;

        public List<String> getFuzzyTime(){return this.fuzzyTime;}

        private List<String> rightFuzzyTime;

        public List<String> getRightFuzzyTime(){return this.rightFuzzyTime;}
        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder F_IDBetWeen(Integer F_IDSt,Integer F_IDEd){
            this.F_IDSt = F_IDSt;
            this.F_IDEd = F_IDEd;
            return this;
        }

        public QueryBuilder F_IDGreaterEqThan(Integer F_IDSt){
            this.F_IDSt = F_IDSt;
            return this;
        }
        public QueryBuilder F_IDLessEqThan(Integer F_IDEd){
            this.F_IDEd = F_IDEd;
            return this;
        }


        public QueryBuilder F_ID(Integer F_ID){
            setF_ID(F_ID);
            return this;
        }

        public QueryBuilder F_IDList(Integer ... F_ID){
            this.F_IDList = solveNullList(F_ID);
            return this;
        }

        public QueryBuilder F_IDList(List<Integer> F_ID){
            this.F_IDList = F_ID;
            return this;
        }

        public QueryBuilder fetchF_ID(){
            setFetchFields("fetchFields","F_ID");
            return this;
        }

        public QueryBuilder excludeF_ID(){
            setFetchFields("excludeFields","F_ID");
            return this;
        }

        public QueryBuilder userIDBetWeen(Integer userIDSt,Integer userIDEd){
            this.userIDSt = userIDSt;
            this.userIDEd = userIDEd;
            return this;
        }

        public QueryBuilder userIDGreaterEqThan(Integer userIDSt){
            this.userIDSt = userIDSt;
            return this;
        }
        public QueryBuilder userIDLessEqThan(Integer userIDEd){
            this.userIDEd = userIDEd;
            return this;
        }


        public QueryBuilder userID(Integer userID){
            setUserID(userID);
            return this;
        }

        public QueryBuilder userIDList(Integer ... userID){
            this.userIDList = solveNullList(userID);
            return this;
        }

        public QueryBuilder userIDList(List<Integer> userID){
            this.userIDList = userID;
            return this;
        }

        public QueryBuilder fetchUserID(){
            setFetchFields("fetchFields","userID");
            return this;
        }

        public QueryBuilder excludeUserID(){
            setFetchFields("excludeFields","userID");
            return this;
        }

        public QueryBuilder friendIDBetWeen(Integer friendIDSt,Integer friendIDEd){
            this.friendIDSt = friendIDSt;
            this.friendIDEd = friendIDEd;
            return this;
        }

        public QueryBuilder friendIDGreaterEqThan(Integer friendIDSt){
            this.friendIDSt = friendIDSt;
            return this;
        }
        public QueryBuilder friendIDLessEqThan(Integer friendIDEd){
            this.friendIDEd = friendIDEd;
            return this;
        }


        public QueryBuilder friendID(Integer friendID){
            setFriendID(friendID);
            return this;
        }

        public QueryBuilder friendIDList(Integer ... friendID){
            this.friendIDList = solveNullList(friendID);
            return this;
        }

        public QueryBuilder friendIDList(List<Integer> friendID){
            this.friendIDList = friendID;
            return this;
        }

        public QueryBuilder fetchFriendID(){
            setFetchFields("fetchFields","friendID");
            return this;
        }

        public QueryBuilder excludeFriendID(){
            setFetchFields("excludeFields","friendID");
            return this;
        }

        public QueryBuilder fuzzyTime (List<String> fuzzyTime){
            this.fuzzyTime = fuzzyTime;
            return this;
        }

        public QueryBuilder fuzzyTime (String ... fuzzyTime){
            this.fuzzyTime = solveNullList(fuzzyTime);
            return this;
        }

        public QueryBuilder rightFuzzyTime (List<String> rightFuzzyTime){
            this.rightFuzzyTime = rightFuzzyTime;
            return this;
        }

        public QueryBuilder rightFuzzyTime (String ... rightFuzzyTime){
            this.rightFuzzyTime = solveNullList(rightFuzzyTime);
            return this;
        }

        public QueryBuilder time(String time){
            setTime(time);
            return this;
        }

        public QueryBuilder timeList(String ... time){
            this.timeList = solveNullList(time);
            return this;
        }

        public QueryBuilder timeList(List<String> time){
            this.timeList = time;
            return this;
        }

        public QueryBuilder fetchTime(){
            setFetchFields("fetchFields","time");
            return this;
        }

        public QueryBuilder excludeTime(){
            setFetchFields("excludeFields","time");
            return this;
        }

        public QueryBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public QueryBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public QueryBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public QueryBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public QueryBuilder name(String name){
            setName(name);
            return this;
        }

        public QueryBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public QueryBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public QueryBuilder fetchName(){
            setFetchFields("fetchFields","name");
            return this;
        }

        public QueryBuilder excludeName(){
            setFetchFields("excludeFields","name");
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

        public Friend build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> F_IDList;

        public List<Integer> getF_IDList(){return this.F_IDList;}

        private Integer F_IDSt;

        private Integer F_IDEd;

        public Integer getF_IDSt(){return this.F_IDSt;}

        public Integer getF_IDEd(){return this.F_IDEd;}

        private List<Integer> userIDList;

        public List<Integer> getUserIDList(){return this.userIDList;}

        private Integer userIDSt;

        private Integer userIDEd;

        public Integer getUserIDSt(){return this.userIDSt;}

        public Integer getUserIDEd(){return this.userIDEd;}

        private List<Integer> friendIDList;

        public List<Integer> getFriendIDList(){return this.friendIDList;}

        private Integer friendIDSt;

        private Integer friendIDEd;

        public Integer getFriendIDSt(){return this.friendIDSt;}

        public Integer getFriendIDEd(){return this.friendIDEd;}

        private List<String> timeList;

        public List<String> getTimeList(){return this.timeList;}


        private List<String> fuzzyTime;

        public List<String> getFuzzyTime(){return this.fuzzyTime;}

        private List<String> rightFuzzyTime;

        public List<String> getRightFuzzyTime(){return this.rightFuzzyTime;}
        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}

        public ConditionBuilder F_IDBetWeen(Integer F_IDSt,Integer F_IDEd){
            this.F_IDSt = F_IDSt;
            this.F_IDEd = F_IDEd;
            return this;
        }

        public ConditionBuilder F_IDGreaterEqThan(Integer F_IDSt){
            this.F_IDSt = F_IDSt;
            return this;
        }
        public ConditionBuilder F_IDLessEqThan(Integer F_IDEd){
            this.F_IDEd = F_IDEd;
            return this;
        }


        public ConditionBuilder F_IDList(Integer ... F_ID){
            this.F_IDList = solveNullList(F_ID);
            return this;
        }

        public ConditionBuilder F_IDList(List<Integer> F_ID){
            this.F_IDList = F_ID;
            return this;
        }

        public ConditionBuilder userIDBetWeen(Integer userIDSt,Integer userIDEd){
            this.userIDSt = userIDSt;
            this.userIDEd = userIDEd;
            return this;
        }

        public ConditionBuilder userIDGreaterEqThan(Integer userIDSt){
            this.userIDSt = userIDSt;
            return this;
        }
        public ConditionBuilder userIDLessEqThan(Integer userIDEd){
            this.userIDEd = userIDEd;
            return this;
        }


        public ConditionBuilder userIDList(Integer ... userID){
            this.userIDList = solveNullList(userID);
            return this;
        }

        public ConditionBuilder userIDList(List<Integer> userID){
            this.userIDList = userID;
            return this;
        }

        public ConditionBuilder friendIDBetWeen(Integer friendIDSt,Integer friendIDEd){
            this.friendIDSt = friendIDSt;
            this.friendIDEd = friendIDEd;
            return this;
        }

        public ConditionBuilder friendIDGreaterEqThan(Integer friendIDSt){
            this.friendIDSt = friendIDSt;
            return this;
        }
        public ConditionBuilder friendIDLessEqThan(Integer friendIDEd){
            this.friendIDEd = friendIDEd;
            return this;
        }


        public ConditionBuilder friendIDList(Integer ... friendID){
            this.friendIDList = solveNullList(friendID);
            return this;
        }

        public ConditionBuilder friendIDList(List<Integer> friendID){
            this.friendIDList = friendID;
            return this;
        }

        public ConditionBuilder fuzzyTime (List<String> fuzzyTime){
            this.fuzzyTime = fuzzyTime;
            return this;
        }

        public ConditionBuilder fuzzyTime (String ... fuzzyTime){
            this.fuzzyTime = solveNullList(fuzzyTime);
            return this;
        }

        public ConditionBuilder rightFuzzyTime (List<String> rightFuzzyTime){
            this.rightFuzzyTime = rightFuzzyTime;
            return this;
        }

        public ConditionBuilder rightFuzzyTime (String ... rightFuzzyTime){
            this.rightFuzzyTime = solveNullList(rightFuzzyTime);
            return this;
        }

        public ConditionBuilder timeList(String ... time){
            this.timeList = solveNullList(time);
            return this;
        }

        public ConditionBuilder timeList(List<String> time){
            this.timeList = time;
            return this;
        }

        public ConditionBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public ConditionBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public ConditionBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public ConditionBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public ConditionBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public ConditionBuilder nameList(List<String> name){
            this.nameList = name;
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

        private Friend obj;

        public Builder(){
            this.obj = new Friend();
        }

        public Builder F_ID(Integer F_ID){
            this.obj.setF_ID(F_ID);
            return this;
        }
        public Builder userID(Integer userID){
            this.obj.setUserID(userID);
            return this;
        }
        public Builder friendID(Integer friendID){
            this.obj.setFriendID(friendID);
            return this;
        }
        public Builder time(String time){
            this.obj.setTime(time);
            return this;
        }
        public Builder name(String name){
            this.obj.setName(name);
            return this;
        }
        public Friend build(){return obj;}
    }

}
