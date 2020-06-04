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
public class GMSGSend implements Serializable {

    private static final long serialVersionUID = 1591299340988L;


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
    private Integer receiverID;

    /**
    * 
    * isNullAble:0
    */
    private Integer GM_ID;

    /**
    * 
    * isNullAble:0
    */
    private Integer groupID;

    /**
    * 
    * isNullAble:0,defaultVal:0
    */
    private Integer status;


    public void setID(Integer ID){this.ID = ID;}

    public Integer getID(){return this.ID;}

    public void setReceiverID(Integer receiverID){this.receiverID = receiverID;}

    public Integer getReceiverID(){return this.receiverID;}

    public void setGM_ID(Integer GM_ID){this.GM_ID = GM_ID;}

    public Integer getGM_ID(){return this.GM_ID;}

    public void setGroupID(Integer groupID){this.groupID = groupID;}

    public Integer getGroupID(){return this.groupID;}

    public void setStatus(Integer status){this.status = status;}

    public Integer getStatus(){return this.status;}
    @Override
    public String toString() {
        return "GMSGSend{" +
                "ID='" + ID + '\'' +
                "receiverID='" + receiverID + '\'' +
                "GM_ID='" + GM_ID + '\'' +
                "groupID='" + groupID + '\'' +
                "status='" + status + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private GMSGSend set;

        private ConditionBuilder where;

        public UpdateBuilder set(GMSGSend set){
            this.set = set;
            return this;
        }

        public GMSGSend getSet(){
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

    public static class QueryBuilder extends GMSGSend{
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

        private List<Integer> receiverIDList;

        public List<Integer> getReceiverIDList(){return this.receiverIDList;}

        private Integer receiverIDSt;

        private Integer receiverIDEd;

        public Integer getReceiverIDSt(){return this.receiverIDSt;}

        public Integer getReceiverIDEd(){return this.receiverIDEd;}

        private List<Integer> GM_IDList;

        public List<Integer> getGM_IDList(){return this.GM_IDList;}

        private Integer GM_IDSt;

        private Integer GM_IDEd;

        public Integer getGM_IDSt(){return this.GM_IDSt;}

        public Integer getGM_IDEd(){return this.GM_IDEd;}

        private List<Integer> groupIDList;

        public List<Integer> getGroupIDList(){return this.groupIDList;}

        private Integer groupIDSt;

        private Integer groupIDEd;

        public Integer getGroupIDSt(){return this.groupIDSt;}

        public Integer getGroupIDEd(){return this.groupIDEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

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

        public QueryBuilder GM_IDBetWeen(Integer GM_IDSt,Integer GM_IDEd){
            this.GM_IDSt = GM_IDSt;
            this.GM_IDEd = GM_IDEd;
            return this;
        }

        public QueryBuilder GM_IDGreaterEqThan(Integer GM_IDSt){
            this.GM_IDSt = GM_IDSt;
            return this;
        }
        public QueryBuilder GM_IDLessEqThan(Integer GM_IDEd){
            this.GM_IDEd = GM_IDEd;
            return this;
        }


        public QueryBuilder GM_ID(Integer GM_ID){
            setGM_ID(GM_ID);
            return this;
        }

        public QueryBuilder GM_IDList(Integer ... GM_ID){
            this.GM_IDList = solveNullList(GM_ID);
            return this;
        }

        public QueryBuilder GM_IDList(List<Integer> GM_ID){
            this.GM_IDList = GM_ID;
            return this;
        }

        public QueryBuilder fetchGM_ID(){
            setFetchFields("fetchFields","GM_ID");
            return this;
        }

        public QueryBuilder excludeGM_ID(){
            setFetchFields("excludeFields","GM_ID");
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

        public GMSGSend build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> IDList;

        public List<Integer> getIDList(){return this.IDList;}

        private Integer IDSt;

        private Integer IDEd;

        public Integer getIDSt(){return this.IDSt;}

        public Integer getIDEd(){return this.IDEd;}

        private List<Integer> receiverIDList;

        public List<Integer> getReceiverIDList(){return this.receiverIDList;}

        private Integer receiverIDSt;

        private Integer receiverIDEd;

        public Integer getReceiverIDSt(){return this.receiverIDSt;}

        public Integer getReceiverIDEd(){return this.receiverIDEd;}

        private List<Integer> GM_IDList;

        public List<Integer> getGM_IDList(){return this.GM_IDList;}

        private Integer GM_IDSt;

        private Integer GM_IDEd;

        public Integer getGM_IDSt(){return this.GM_IDSt;}

        public Integer getGM_IDEd(){return this.GM_IDEd;}

        private List<Integer> groupIDList;

        public List<Integer> getGroupIDList(){return this.groupIDList;}

        private Integer groupIDSt;

        private Integer groupIDEd;

        public Integer getGroupIDSt(){return this.groupIDSt;}

        public Integer getGroupIDEd(){return this.groupIDEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}


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

        public ConditionBuilder GM_IDBetWeen(Integer GM_IDSt,Integer GM_IDEd){
            this.GM_IDSt = GM_IDSt;
            this.GM_IDEd = GM_IDEd;
            return this;
        }

        public ConditionBuilder GM_IDGreaterEqThan(Integer GM_IDSt){
            this.GM_IDSt = GM_IDSt;
            return this;
        }
        public ConditionBuilder GM_IDLessEqThan(Integer GM_IDEd){
            this.GM_IDEd = GM_IDEd;
            return this;
        }


        public ConditionBuilder GM_IDList(Integer ... GM_ID){
            this.GM_IDList = solveNullList(GM_ID);
            return this;
        }

        public ConditionBuilder GM_IDList(List<Integer> GM_ID){
            this.GM_IDList = GM_ID;
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

        private GMSGSend obj;

        public Builder(){
            this.obj = new GMSGSend();
        }

        public Builder ID(Integer ID){
            this.obj.setID(ID);
            return this;
        }
        public Builder receiverID(Integer receiverID){
            this.obj.setReceiverID(receiverID);
            return this;
        }
        public Builder GM_ID(Integer GM_ID){
            this.obj.setGM_ID(GM_ID);
            return this;
        }
        public Builder groupID(Integer groupID){
            this.obj.setGroupID(groupID);
            return this;
        }
        public Builder status(Integer status){
            this.obj.setStatus(status);
            return this;
        }
        public GMSGSend build(){return obj;}
    }

}
