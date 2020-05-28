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
public class Members implements Serializable {

    private static final long serialVersionUID = 1590646430508L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer ID;

    /**
    * 
    * isNullAble:0
    */
    private Integer groupID;

    /**
    * 
    * isNullAble:0
    */
    private Integer memberID;

    /**
    * 
    * isNullAble:0
    */
    private String time;

    /**
    * 
    * isNullAble:0
    */
    private Integer inviterID;


    public void setID(Integer ID){this.ID = ID;}

    public Integer getID(){return this.ID;}

    public void setGroupID(Integer groupID){this.groupID = groupID;}

    public Integer getGroupID(){return this.groupID;}

    public void setMemberID(Integer memberID){this.memberID = memberID;}

    public Integer getMemberID(){return this.memberID;}

    public void setTime(String time){this.time = time;}

    public String getTime(){return this.time;}

    public void setInviterID(Integer inviterID){this.inviterID = inviterID;}

    public Integer getInviterID(){return this.inviterID;}
    @Override
    public String toString() {
        return "Members{" +
                "ID='" + ID + '\'' +
                "groupID='" + groupID + '\'' +
                "memberID='" + memberID + '\'' +
                "time='" + time + '\'' +
                "inviterID='" + inviterID + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Members set;

        private ConditionBuilder where;

        public UpdateBuilder set(Members set){
            this.set = set;
            return this;
        }

        public Members getSet(){
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

    public static class QueryBuilder extends Members{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> IDList;

        public List<Integer> getIDList(){return this.IDList;}

        private Integer IDSt;

        private Integer IDEd;

        public Integer getIDSt(){return this.IDSt;}

        public Integer getIDEd(){return this.IDEd;}

        private List<Integer> groupIDList;

        public List<Integer> getGroupIDList(){return this.groupIDList;}

        private Integer groupIDSt;

        private Integer groupIDEd;

        public Integer getGroupIDSt(){return this.groupIDSt;}

        public Integer getGroupIDEd(){return this.groupIDEd;}

        private List<Integer> memberIDList;

        public List<Integer> getMemberIDList(){return this.memberIDList;}

        private Integer memberIDSt;

        private Integer memberIDEd;

        public Integer getMemberIDSt(){return this.memberIDSt;}

        public Integer getMemberIDEd(){return this.memberIDEd;}

        private List<String> timeList;

        public List<String> getTimeList(){return this.timeList;}


        private List<String> fuzzyTime;

        public List<String> getFuzzyTime(){return this.fuzzyTime;}

        private List<String> rightFuzzyTime;

        public List<String> getRightFuzzyTime(){return this.rightFuzzyTime;}
        private List<Integer> inviterIDList;

        public List<Integer> getInviterIDList(){return this.inviterIDList;}

        private Integer inviterIDSt;

        private Integer inviterIDEd;

        public Integer getInviterIDSt(){return this.inviterIDSt;}

        public Integer getInviterIDEd(){return this.inviterIDEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder IDBetWeen(Integer IDSt,Integer IDEd){
            this.IDSt = IDSt;
            this.IDEd = IDEd;
            return this;
        }

        public QueryBuilder IDGreaterEqThan(Integer IDSt){
            this.IDSt = IDSt;
            return this;
        }
        public QueryBuilder IDLessEqThan(Integer IDEd){
            this.IDEd = IDEd;
            return this;
        }


        public QueryBuilder ID(Integer ID){
            setID(ID);
            return this;
        }

        public QueryBuilder IDList(Integer ... ID){
            this.IDList = solveNullList(ID);
            return this;
        }

        public QueryBuilder IDList(List<Integer> ID){
            this.IDList = ID;
            return this;
        }

        public QueryBuilder fetchID(){
            setFetchFields("fetchFields","ID");
            return this;
        }

        public QueryBuilder excludeID(){
            setFetchFields("excludeFields","ID");
            return this;
        }

        public QueryBuilder groupIDBetWeen(Integer groupIDSt,Integer groupIDEd){
            this.groupIDSt = groupIDSt;
            this.groupIDEd = groupIDEd;
            return this;
        }

        public QueryBuilder groupIDGreaterEqThan(Integer groupIDSt){
            this.groupIDSt = groupIDSt;
            return this;
        }
        public QueryBuilder groupIDLessEqThan(Integer groupIDEd){
            this.groupIDEd = groupIDEd;
            return this;
        }


        public QueryBuilder groupID(Integer groupID){
            setGroupID(groupID);
            return this;
        }

        public QueryBuilder groupIDList(Integer ... groupID){
            this.groupIDList = solveNullList(groupID);
            return this;
        }

        public QueryBuilder groupIDList(List<Integer> groupID){
            this.groupIDList = groupID;
            return this;
        }

        public QueryBuilder fetchGroupID(){
            setFetchFields("fetchFields","groupID");
            return this;
        }

        public QueryBuilder excludeGroupID(){
            setFetchFields("excludeFields","groupID");
            return this;
        }

        public QueryBuilder memberIDBetWeen(Integer memberIDSt,Integer memberIDEd){
            this.memberIDSt = memberIDSt;
            this.memberIDEd = memberIDEd;
            return this;
        }

        public QueryBuilder memberIDGreaterEqThan(Integer memberIDSt){
            this.memberIDSt = memberIDSt;
            return this;
        }
        public QueryBuilder memberIDLessEqThan(Integer memberIDEd){
            this.memberIDEd = memberIDEd;
            return this;
        }


        public QueryBuilder memberID(Integer memberID){
            setMemberID(memberID);
            return this;
        }

        public QueryBuilder memberIDList(Integer ... memberID){
            this.memberIDList = solveNullList(memberID);
            return this;
        }

        public QueryBuilder memberIDList(List<Integer> memberID){
            this.memberIDList = memberID;
            return this;
        }

        public QueryBuilder fetchMemberID(){
            setFetchFields("fetchFields","memberID");
            return this;
        }

        public QueryBuilder excludeMemberID(){
            setFetchFields("excludeFields","memberID");
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

        public QueryBuilder inviterIDBetWeen(Integer inviterIDSt,Integer inviterIDEd){
            this.inviterIDSt = inviterIDSt;
            this.inviterIDEd = inviterIDEd;
            return this;
        }

        public QueryBuilder inviterIDGreaterEqThan(Integer inviterIDSt){
            this.inviterIDSt = inviterIDSt;
            return this;
        }
        public QueryBuilder inviterIDLessEqThan(Integer inviterIDEd){
            this.inviterIDEd = inviterIDEd;
            return this;
        }


        public QueryBuilder inviterID(Integer inviterID){
            setInviterID(inviterID);
            return this;
        }

        public QueryBuilder inviterIDList(Integer ... inviterID){
            this.inviterIDList = solveNullList(inviterID);
            return this;
        }

        public QueryBuilder inviterIDList(List<Integer> inviterID){
            this.inviterIDList = inviterID;
            return this;
        }

        public QueryBuilder fetchInviterID(){
            setFetchFields("fetchFields","inviterID");
            return this;
        }

        public QueryBuilder excludeInviterID(){
            setFetchFields("excludeFields","inviterID");
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

        public Members build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> IDList;

        public List<Integer> getIDList(){return this.IDList;}

        private Integer IDSt;

        private Integer IDEd;

        public Integer getIDSt(){return this.IDSt;}

        public Integer getIDEd(){return this.IDEd;}

        private List<Integer> groupIDList;

        public List<Integer> getGroupIDList(){return this.groupIDList;}

        private Integer groupIDSt;

        private Integer groupIDEd;

        public Integer getGroupIDSt(){return this.groupIDSt;}

        public Integer getGroupIDEd(){return this.groupIDEd;}

        private List<Integer> memberIDList;

        public List<Integer> getMemberIDList(){return this.memberIDList;}

        private Integer memberIDSt;

        private Integer memberIDEd;

        public Integer getMemberIDSt(){return this.memberIDSt;}

        public Integer getMemberIDEd(){return this.memberIDEd;}

        private List<String> timeList;

        public List<String> getTimeList(){return this.timeList;}


        private List<String> fuzzyTime;

        public List<String> getFuzzyTime(){return this.fuzzyTime;}

        private List<String> rightFuzzyTime;

        public List<String> getRightFuzzyTime(){return this.rightFuzzyTime;}
        private List<Integer> inviterIDList;

        public List<Integer> getInviterIDList(){return this.inviterIDList;}

        private Integer inviterIDSt;

        private Integer inviterIDEd;

        public Integer getInviterIDSt(){return this.inviterIDSt;}

        public Integer getInviterIDEd(){return this.inviterIDEd;}


        public ConditionBuilder IDBetWeen(Integer IDSt,Integer IDEd){
            this.IDSt = IDSt;
            this.IDEd = IDEd;
            return this;
        }

        public ConditionBuilder IDGreaterEqThan(Integer IDSt){
            this.IDSt = IDSt;
            return this;
        }
        public ConditionBuilder IDLessEqThan(Integer IDEd){
            this.IDEd = IDEd;
            return this;
        }


        public ConditionBuilder IDList(Integer ... ID){
            this.IDList = solveNullList(ID);
            return this;
        }

        public ConditionBuilder IDList(List<Integer> ID){
            this.IDList = ID;
            return this;
        }

        public ConditionBuilder groupIDBetWeen(Integer groupIDSt,Integer groupIDEd){
            this.groupIDSt = groupIDSt;
            this.groupIDEd = groupIDEd;
            return this;
        }

        public ConditionBuilder groupIDGreaterEqThan(Integer groupIDSt){
            this.groupIDSt = groupIDSt;
            return this;
        }
        public ConditionBuilder groupIDLessEqThan(Integer groupIDEd){
            this.groupIDEd = groupIDEd;
            return this;
        }


        public ConditionBuilder groupIDList(Integer ... groupID){
            this.groupIDList = solveNullList(groupID);
            return this;
        }

        public ConditionBuilder groupIDList(List<Integer> groupID){
            this.groupIDList = groupID;
            return this;
        }

        public ConditionBuilder memberIDBetWeen(Integer memberIDSt,Integer memberIDEd){
            this.memberIDSt = memberIDSt;
            this.memberIDEd = memberIDEd;
            return this;
        }

        public ConditionBuilder memberIDGreaterEqThan(Integer memberIDSt){
            this.memberIDSt = memberIDSt;
            return this;
        }
        public ConditionBuilder memberIDLessEqThan(Integer memberIDEd){
            this.memberIDEd = memberIDEd;
            return this;
        }


        public ConditionBuilder memberIDList(Integer ... memberID){
            this.memberIDList = solveNullList(memberID);
            return this;
        }

        public ConditionBuilder memberIDList(List<Integer> memberID){
            this.memberIDList = memberID;
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

        public ConditionBuilder inviterIDBetWeen(Integer inviterIDSt,Integer inviterIDEd){
            this.inviterIDSt = inviterIDSt;
            this.inviterIDEd = inviterIDEd;
            return this;
        }

        public ConditionBuilder inviterIDGreaterEqThan(Integer inviterIDSt){
            this.inviterIDSt = inviterIDSt;
            return this;
        }
        public ConditionBuilder inviterIDLessEqThan(Integer inviterIDEd){
            this.inviterIDEd = inviterIDEd;
            return this;
        }


        public ConditionBuilder inviterIDList(Integer ... inviterID){
            this.inviterIDList = solveNullList(inviterID);
            return this;
        }

        public ConditionBuilder inviterIDList(List<Integer> inviterID){
            this.inviterIDList = inviterID;
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

        private Members obj;

        public Builder(){
            this.obj = new Members();
        }

        public Builder ID(Integer ID){
            this.obj.setID(ID);
            return this;
        }
        public Builder groupID(Integer groupID){
            this.obj.setGroupID(groupID);
            return this;
        }
        public Builder memberID(Integer memberID){
            this.obj.setMemberID(memberID);
            return this;
        }
        public Builder time(String time){
            this.obj.setTime(time);
            return this;
        }
        public Builder inviterID(Integer inviterID){
            this.obj.setInviterID(inviterID);
            return this;
        }
        public Members build(){return obj;}
    }

}
