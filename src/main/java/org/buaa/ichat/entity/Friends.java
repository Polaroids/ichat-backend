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
public class Friends implements Serializable {

    private static final long serialVersionUID = 1590641262504L;


    /**
    * 
    * isNullAble:0
    */
    private Integer receiverID;

    /**
    * 
    * isNullAble:0
    */
    private Integer status;

    /**
    * 
    * isNullAble:0
    */
    private String time;

    /**
    * 
    * isNullAble:0
    */
    private Integer senderID;

    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;


    public void setReceiverID(Integer receiverID){this.receiverID = receiverID;}

    public Integer getReceiverID(){return this.receiverID;}

    public void setStatus(Integer status){this.status = status;}

    public Integer getStatus(){return this.status;}

    public void setTime(String time){this.time = time;}

    public String getTime(){return this.time;}

    public void setSenderID(Integer senderID){this.senderID = senderID;}

    public Integer getSenderID(){return this.senderID;}

    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}
    @Override
    public String toString() {
        return "Friends{" +
                "receiverID='" + receiverID + '\'' +
                "status='" + status + '\'' +
                "time='" + time + '\'' +
                "senderID='" + senderID + '\'' +
                "id='" + id + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Friends set;

        private ConditionBuilder where;

        public UpdateBuilder set(Friends set){
            this.set = set;
            return this;
        }

        public Friends getSet(){
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

    public static class QueryBuilder extends Friends{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> receiverIDList;

        public List<Integer> getReceiverIDList(){return this.receiverIDList;}

        private Integer receiverIDSt;

        private Integer receiverIDEd;

        public Integer getReceiverIDSt(){return this.receiverIDSt;}

        public Integer getReceiverIDEd(){return this.receiverIDEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private List<String> timeList;

        public List<String> getTimeList(){return this.timeList;}


        private List<String> fuzzyTime;

        public List<String> getFuzzyTime(){return this.fuzzyTime;}

        private List<String> rightFuzzyTime;

        public List<String> getRightFuzzyTime(){return this.rightFuzzyTime;}
        private List<Integer> senderIDList;

        public List<Integer> getSenderIDList(){return this.senderIDList;}

        private Integer senderIDSt;

        private Integer senderIDEd;

        public Integer getSenderIDSt(){return this.senderIDSt;}

        public Integer getSenderIDEd(){return this.senderIDEd;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder receiverIDBetWeen(Integer receiverIDSt,Integer receiverIDEd){
            this.receiverIDSt = receiverIDSt;
            this.receiverIDEd = receiverIDEd;
            return this;
        }

        public QueryBuilder receiverIDGreaterEqThan(Integer receiverIDSt){
            this.receiverIDSt = receiverIDSt;
            return this;
        }
        public QueryBuilder receiverIDLessEqThan(Integer receiverIDEd){
            this.receiverIDEd = receiverIDEd;
            return this;
        }


        public QueryBuilder receiverID(Integer receiverID){
            setReceiverID(receiverID);
            return this;
        }

        public QueryBuilder receiverIDList(Integer ... receiverID){
            this.receiverIDList = solveNullList(receiverID);
            return this;
        }

        public QueryBuilder receiverIDList(List<Integer> receiverID){
            this.receiverIDList = receiverID;
            return this;
        }

        public QueryBuilder fetchReceiverID(){
            setFetchFields("fetchFields","receiverID");
            return this;
        }

        public QueryBuilder excludeReceiverID(){
            setFetchFields("excludeFields","receiverID");
            return this;
        }

        public QueryBuilder statusBetWeen(Integer statusSt,Integer statusEd){
            this.statusSt = statusSt;
            this.statusEd = statusEd;
            return this;
        }

        public QueryBuilder statusGreaterEqThan(Integer statusSt){
            this.statusSt = statusSt;
            return this;
        }
        public QueryBuilder statusLessEqThan(Integer statusEd){
            this.statusEd = statusEd;
            return this;
        }


        public QueryBuilder status(Integer status){
            setStatus(status);
            return this;
        }

        public QueryBuilder statusList(Integer ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public QueryBuilder statusList(List<Integer> status){
            this.statusList = status;
            return this;
        }

        public QueryBuilder fetchStatus(){
            setFetchFields("fetchFields","status");
            return this;
        }

        public QueryBuilder excludeStatus(){
            setFetchFields("excludeFields","status");
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

        public QueryBuilder senderIDBetWeen(Integer senderIDSt,Integer senderIDEd){
            this.senderIDSt = senderIDSt;
            this.senderIDEd = senderIDEd;
            return this;
        }

        public QueryBuilder senderIDGreaterEqThan(Integer senderIDSt){
            this.senderIDSt = senderIDSt;
            return this;
        }
        public QueryBuilder senderIDLessEqThan(Integer senderIDEd){
            this.senderIDEd = senderIDEd;
            return this;
        }


        public QueryBuilder senderID(Integer senderID){
            setSenderID(senderID);
            return this;
        }

        public QueryBuilder senderIDList(Integer ... senderID){
            this.senderIDList = solveNullList(senderID);
            return this;
        }

        public QueryBuilder senderIDList(List<Integer> senderID){
            this.senderIDList = senderID;
            return this;
        }

        public QueryBuilder fetchSenderID(){
            setFetchFields("fetchFields","senderID");
            return this;
        }

        public QueryBuilder excludeSenderID(){
            setFetchFields("excludeFields","senderID");
            return this;
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

        public Friends build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> receiverIDList;

        public List<Integer> getReceiverIDList(){return this.receiverIDList;}

        private Integer receiverIDSt;

        private Integer receiverIDEd;

        public Integer getReceiverIDSt(){return this.receiverIDSt;}

        public Integer getReceiverIDEd(){return this.receiverIDEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private List<String> timeList;

        public List<String> getTimeList(){return this.timeList;}


        private List<String> fuzzyTime;

        public List<String> getFuzzyTime(){return this.fuzzyTime;}

        private List<String> rightFuzzyTime;

        public List<String> getRightFuzzyTime(){return this.rightFuzzyTime;}
        private List<Integer> senderIDList;

        public List<Integer> getSenderIDList(){return this.senderIDList;}

        private Integer senderIDSt;

        private Integer senderIDEd;

        public Integer getSenderIDSt(){return this.senderIDSt;}

        public Integer getSenderIDEd(){return this.senderIDEd;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}


        public ConditionBuilder receiverIDBetWeen(Integer receiverIDSt,Integer receiverIDEd){
            this.receiverIDSt = receiverIDSt;
            this.receiverIDEd = receiverIDEd;
            return this;
        }

        public ConditionBuilder receiverIDGreaterEqThan(Integer receiverIDSt){
            this.receiverIDSt = receiverIDSt;
            return this;
        }
        public ConditionBuilder receiverIDLessEqThan(Integer receiverIDEd){
            this.receiverIDEd = receiverIDEd;
            return this;
        }


        public ConditionBuilder receiverIDList(Integer ... receiverID){
            this.receiverIDList = solveNullList(receiverID);
            return this;
        }

        public ConditionBuilder receiverIDList(List<Integer> receiverID){
            this.receiverIDList = receiverID;
            return this;
        }

        public ConditionBuilder statusBetWeen(Integer statusSt,Integer statusEd){
            this.statusSt = statusSt;
            this.statusEd = statusEd;
            return this;
        }

        public ConditionBuilder statusGreaterEqThan(Integer statusSt){
            this.statusSt = statusSt;
            return this;
        }
        public ConditionBuilder statusLessEqThan(Integer statusEd){
            this.statusEd = statusEd;
            return this;
        }


        public ConditionBuilder statusList(Integer ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public ConditionBuilder statusList(List<Integer> status){
            this.statusList = status;
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

        public ConditionBuilder senderIDBetWeen(Integer senderIDSt,Integer senderIDEd){
            this.senderIDSt = senderIDSt;
            this.senderIDEd = senderIDEd;
            return this;
        }

        public ConditionBuilder senderIDGreaterEqThan(Integer senderIDSt){
            this.senderIDSt = senderIDSt;
            return this;
        }
        public ConditionBuilder senderIDLessEqThan(Integer senderIDEd){
            this.senderIDEd = senderIDEd;
            return this;
        }


        public ConditionBuilder senderIDList(Integer ... senderID){
            this.senderIDList = solveNullList(senderID);
            return this;
        }

        public ConditionBuilder senderIDList(List<Integer> senderID){
            this.senderIDList = senderID;
            return this;
        }

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

        private Friends obj;

        public Builder(){
            this.obj = new Friends();
        }

        public Builder receiverID(Integer receiverID){
            this.obj.setReceiverID(receiverID);
            return this;
        }
        public Builder status(Integer status){
            this.obj.setStatus(status);
            return this;
        }
        public Builder time(String time){
            this.obj.setTime(time);
            return this;
        }
        public Builder senderID(Integer senderID){
            this.obj.setSenderID(senderID);
            return this;
        }
        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Friends build(){return obj;}
    }

}
