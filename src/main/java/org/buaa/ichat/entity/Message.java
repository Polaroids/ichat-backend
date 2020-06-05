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
public class Message implements Serializable {

    private static final long serialVersionUID = 1591299250889L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer messageID;

    /**
    * 
    * isNullAble:0
    */
    private String content;

    /**
    * 
    * isNullAble:0
    */
    private Integer sent;

    /**
    * 
    * isNullAble:0
    */
    private String sentTime;

    /**
    * 
    * isNullAble:0,defaultVal:0
    */
    private Integer type;

    /**
    * 
    * isNullAble:0
    */
    private Integer senderID;

    /**
    * 
    * isNullAble:0
    */
    private Integer receiverID;


    public void setMessageID(Integer messageID){this.messageID = messageID;}

    public Integer getMessageID(){return this.messageID;}

    public void setContent(String content){this.content = content;}

    public String getContent(){return this.content;}

    public void setSent(Integer sent){this.sent = sent;}

    public Integer getSent(){return this.sent;}

    public void setSentTime(String sentTime){this.sentTime = sentTime;}

    public String getSentTime(){return this.sentTime;}

    public void setType(Integer type){this.type = type;}

    public Integer getType(){return this.type;}

    public void setSenderID(Integer senderID){this.senderID = senderID;}

    public Integer getSenderID(){return this.senderID;}

    public void setReceiverID(Integer receiverID){this.receiverID = receiverID;}

    public Integer getReceiverID(){return this.receiverID;}
    @Override
    public String toString() {
        return "Message{" +
                "messageID='" + messageID + '\'' +
                "content='" + content + '\'' +
                "sent='" + sent + '\'' +
                "sentTime='" + sentTime + '\'' +
                "type='" + type + '\'' +
                "senderID='" + senderID + '\'' +
                "receiverID='" + receiverID + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Message set;

        private ConditionBuilder where;

        public UpdateBuilder set(Message set){
            this.set = set;
            return this;
        }

        public Message getSet(){
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

    public static class QueryBuilder extends Message{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> messageIDList;

        public List<Integer> getMessageIDList(){return this.messageIDList;}

        private Integer messageIDSt;

        private Integer messageIDEd;

        public Integer getMessageIDSt(){return this.messageIDSt;}

        public Integer getMessageIDEd(){return this.messageIDEd;}

        private List<String> contentList;

        public List<String> getContentList(){return this.contentList;}


        private List<String> fuzzyContent;

        public List<String> getFuzzyContent(){return this.fuzzyContent;}

        private List<String> rightFuzzyContent;

        public List<String> getRightFuzzyContent(){return this.rightFuzzyContent;}
        private List<Integer> sentList;

        public List<Integer> getSentList(){return this.sentList;}

        private Integer sentSt;

        private Integer sentEd;

        public Integer getSentSt(){return this.sentSt;}

        public Integer getSentEd(){return this.sentEd;}

        private List<String> sentTimeList;

        public List<String> getSentTimeList(){return this.sentTimeList;}


        private List<String> fuzzySentTime;

        public List<String> getFuzzySentTime(){return this.fuzzySentTime;}

        private List<String> rightFuzzySentTime;

        public List<String> getRightFuzzySentTime(){return this.rightFuzzySentTime;}
        private List<Integer> typeList;

        public List<Integer> getTypeList(){return this.typeList;}

        private Integer typeSt;

        private Integer typeEd;

        public Integer getTypeSt(){return this.typeSt;}

        public Integer getTypeEd(){return this.typeEd;}

        private List<Integer> senderIDList;

        public List<Integer> getSenderIDList(){return this.senderIDList;}

        private Integer senderIDSt;

        private Integer senderIDEd;

        public Integer getSenderIDSt(){return this.senderIDSt;}

        public Integer getSenderIDEd(){return this.senderIDEd;}

        private List<Integer> receiverIDList;

        public List<Integer> getReceiverIDList(){return this.receiverIDList;}

        private Integer receiverIDSt;

        private Integer receiverIDEd;

        public Integer getReceiverIDSt(){return this.receiverIDSt;}

        public Integer getReceiverIDEd(){return this.receiverIDEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder messageIDBetWeen(Integer messageIDSt,Integer messageIDEd){
            this.messageIDSt = messageIDSt;
            this.messageIDEd = messageIDEd;
            return this;
        }

        public QueryBuilder messageIDGreaterEqThan(Integer messageIDSt){
            this.messageIDSt = messageIDSt;
            return this;
        }
        public QueryBuilder messageIDLessEqThan(Integer messageIDEd){
            this.messageIDEd = messageIDEd;
            return this;
        }


        public QueryBuilder messageID(Integer messageID){
            setMessageID(messageID);
            return this;
        }

        public QueryBuilder messageIDList(Integer ... messageID){
            this.messageIDList = solveNullList(messageID);
            return this;
        }

        public QueryBuilder messageIDList(List<Integer> messageID){
            this.messageIDList = messageID;
            return this;
        }

        public QueryBuilder fetchMessageID(){
            setFetchFields("fetchFields","messageID");
            return this;
        }

        public QueryBuilder excludeMessageID(){
            setFetchFields("excludeFields","messageID");
            return this;
        }

        public QueryBuilder fuzzyContent (List<String> fuzzyContent){
            this.fuzzyContent = fuzzyContent;
            return this;
        }

        public QueryBuilder fuzzyContent (String ... fuzzyContent){
            this.fuzzyContent = solveNullList(fuzzyContent);
            return this;
        }

        public QueryBuilder rightFuzzyContent (List<String> rightFuzzyContent){
            this.rightFuzzyContent = rightFuzzyContent;
            return this;
        }

        public QueryBuilder rightFuzzyContent (String ... rightFuzzyContent){
            this.rightFuzzyContent = solveNullList(rightFuzzyContent);
            return this;
        }

        public QueryBuilder content(String content){
            setContent(content);
            return this;
        }

        public QueryBuilder contentList(String ... content){
            this.contentList = solveNullList(content);
            return this;
        }

        public QueryBuilder contentList(List<String> content){
            this.contentList = content;
            return this;
        }

        public QueryBuilder fetchContent(){
            setFetchFields("fetchFields","content");
            return this;
        }

        public QueryBuilder excludeContent(){
            setFetchFields("excludeFields","content");
            return this;
        }

        public QueryBuilder sentBetWeen(Integer sentSt,Integer sentEd){
            this.sentSt = sentSt;
            this.sentEd = sentEd;
            return this;
        }

        public QueryBuilder sentGreaterEqThan(Integer sentSt){
            this.sentSt = sentSt;
            return this;
        }
        public QueryBuilder sentLessEqThan(Integer sentEd){
            this.sentEd = sentEd;
            return this;
        }


        public QueryBuilder sent(Integer sent){
            setSent(sent);
            return this;
        }

        public QueryBuilder sentList(Integer ... sent){
            this.sentList = solveNullList(sent);
            return this;
        }

        public QueryBuilder sentList(List<Integer> sent){
            this.sentList = sent;
            return this;
        }

        public QueryBuilder fetchSent(){
            setFetchFields("fetchFields","sent");
            return this;
        }

        public QueryBuilder excludeSent(){
            setFetchFields("excludeFields","sent");
            return this;
        }

        public QueryBuilder fuzzySentTime (List<String> fuzzySentTime){
            this.fuzzySentTime = fuzzySentTime;
            return this;
        }

        public QueryBuilder fuzzySentTime (String ... fuzzySentTime){
            this.fuzzySentTime = solveNullList(fuzzySentTime);
            return this;
        }

        public QueryBuilder rightFuzzySentTime (List<String> rightFuzzySentTime){
            this.rightFuzzySentTime = rightFuzzySentTime;
            return this;
        }

        public QueryBuilder rightFuzzySentTime (String ... rightFuzzySentTime){
            this.rightFuzzySentTime = solveNullList(rightFuzzySentTime);
            return this;
        }

        public QueryBuilder sentTime(String sentTime){
            setSentTime(sentTime);
            return this;
        }

        public QueryBuilder sentTimeList(String ... sentTime){
            this.sentTimeList = solveNullList(sentTime);
            return this;
        }

        public QueryBuilder sentTimeList(List<String> sentTime){
            this.sentTimeList = sentTime;
            return this;
        }

        public QueryBuilder fetchSentTime(){
            setFetchFields("fetchFields","sentTime");
            return this;
        }

        public QueryBuilder excludeSentTime(){
            setFetchFields("excludeFields","sentTime");
            return this;
        }

        public QueryBuilder typeBetWeen(Integer typeSt,Integer typeEd){
            this.typeSt = typeSt;
            this.typeEd = typeEd;
            return this;
        }

        public QueryBuilder typeGreaterEqThan(Integer typeSt){
            this.typeSt = typeSt;
            return this;
        }
        public QueryBuilder typeLessEqThan(Integer typeEd){
            this.typeEd = typeEd;
            return this;
        }


        public QueryBuilder type(Integer type){
            setType(type);
            return this;
        }

        public QueryBuilder typeList(Integer ... type){
            this.typeList = solveNullList(type);
            return this;
        }

        public QueryBuilder typeList(List<Integer> type){
            this.typeList = type;
            return this;
        }

        public QueryBuilder fetchType(){
            setFetchFields("fetchFields","type");
            return this;
        }

        public QueryBuilder excludeType(){
            setFetchFields("excludeFields","type");
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

        public Message build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> messageIDList;

        public List<Integer> getMessageIDList(){return this.messageIDList;}

        private Integer messageIDSt;

        private Integer messageIDEd;

        public Integer getMessageIDSt(){return this.messageIDSt;}

        public Integer getMessageIDEd(){return this.messageIDEd;}

        private List<String> contentList;

        public List<String> getContentList(){return this.contentList;}


        private List<String> fuzzyContent;

        public List<String> getFuzzyContent(){return this.fuzzyContent;}

        private List<String> rightFuzzyContent;

        public List<String> getRightFuzzyContent(){return this.rightFuzzyContent;}
        private List<Integer> sentList;

        public List<Integer> getSentList(){return this.sentList;}

        private Integer sentSt;

        private Integer sentEd;

        public Integer getSentSt(){return this.sentSt;}

        public Integer getSentEd(){return this.sentEd;}

        private List<String> sentTimeList;

        public List<String> getSentTimeList(){return this.sentTimeList;}


        private List<String> fuzzySentTime;

        public List<String> getFuzzySentTime(){return this.fuzzySentTime;}

        private List<String> rightFuzzySentTime;

        public List<String> getRightFuzzySentTime(){return this.rightFuzzySentTime;}
        private List<Integer> typeList;

        public List<Integer> getTypeList(){return this.typeList;}

        private Integer typeSt;

        private Integer typeEd;

        public Integer getTypeSt(){return this.typeSt;}

        public Integer getTypeEd(){return this.typeEd;}

        private List<Integer> senderIDList;

        public List<Integer> getSenderIDList(){return this.senderIDList;}

        private Integer senderIDSt;

        private Integer senderIDEd;

        public Integer getSenderIDSt(){return this.senderIDSt;}

        public Integer getSenderIDEd(){return this.senderIDEd;}

        private List<Integer> receiverIDList;

        public List<Integer> getReceiverIDList(){return this.receiverIDList;}

        private Integer receiverIDSt;

        private Integer receiverIDEd;

        public Integer getReceiverIDSt(){return this.receiverIDSt;}

        public Integer getReceiverIDEd(){return this.receiverIDEd;}


        public ConditionBuilder messageIDBetWeen(Integer messageIDSt,Integer messageIDEd){
            this.messageIDSt = messageIDSt;
            this.messageIDEd = messageIDEd;
            return this;
        }

        public ConditionBuilder messageIDGreaterEqThan(Integer messageIDSt){
            this.messageIDSt = messageIDSt;
            return this;
        }
        public ConditionBuilder messageIDLessEqThan(Integer messageIDEd){
            this.messageIDEd = messageIDEd;
            return this;
        }


        public ConditionBuilder messageIDList(Integer ... messageID){
            this.messageIDList = solveNullList(messageID);
            return this;
        }

        public ConditionBuilder messageIDList(List<Integer> messageID){
            this.messageIDList = messageID;
            return this;
        }

        public ConditionBuilder fuzzyContent (List<String> fuzzyContent){
            this.fuzzyContent = fuzzyContent;
            return this;
        }

        public ConditionBuilder fuzzyContent (String ... fuzzyContent){
            this.fuzzyContent = solveNullList(fuzzyContent);
            return this;
        }

        public ConditionBuilder rightFuzzyContent (List<String> rightFuzzyContent){
            this.rightFuzzyContent = rightFuzzyContent;
            return this;
        }

        public ConditionBuilder rightFuzzyContent (String ... rightFuzzyContent){
            this.rightFuzzyContent = solveNullList(rightFuzzyContent);
            return this;
        }

        public ConditionBuilder contentList(String ... content){
            this.contentList = solveNullList(content);
            return this;
        }

        public ConditionBuilder contentList(List<String> content){
            this.contentList = content;
            return this;
        }

        public ConditionBuilder sentBetWeen(Integer sentSt,Integer sentEd){
            this.sentSt = sentSt;
            this.sentEd = sentEd;
            return this;
        }

        public ConditionBuilder sentGreaterEqThan(Integer sentSt){
            this.sentSt = sentSt;
            return this;
        }
        public ConditionBuilder sentLessEqThan(Integer sentEd){
            this.sentEd = sentEd;
            return this;
        }


        public ConditionBuilder sentList(Integer ... sent){
            this.sentList = solveNullList(sent);
            return this;
        }

        public ConditionBuilder sentList(List<Integer> sent){
            this.sentList = sent;
            return this;
        }

        public ConditionBuilder fuzzySentTime (List<String> fuzzySentTime){
            this.fuzzySentTime = fuzzySentTime;
            return this;
        }

        public ConditionBuilder fuzzySentTime (String ... fuzzySentTime){
            this.fuzzySentTime = solveNullList(fuzzySentTime);
            return this;
        }

        public ConditionBuilder rightFuzzySentTime (List<String> rightFuzzySentTime){
            this.rightFuzzySentTime = rightFuzzySentTime;
            return this;
        }

        public ConditionBuilder rightFuzzySentTime (String ... rightFuzzySentTime){
            this.rightFuzzySentTime = solveNullList(rightFuzzySentTime);
            return this;
        }

        public ConditionBuilder sentTimeList(String ... sentTime){
            this.sentTimeList = solveNullList(sentTime);
            return this;
        }

        public ConditionBuilder sentTimeList(List<String> sentTime){
            this.sentTimeList = sentTime;
            return this;
        }

        public ConditionBuilder typeBetWeen(Integer typeSt,Integer typeEd){
            this.typeSt = typeSt;
            this.typeEd = typeEd;
            return this;
        }

        public ConditionBuilder typeGreaterEqThan(Integer typeSt){
            this.typeSt = typeSt;
            return this;
        }
        public ConditionBuilder typeLessEqThan(Integer typeEd){
            this.typeEd = typeEd;
            return this;
        }


        public ConditionBuilder typeList(Integer ... type){
            this.typeList = solveNullList(type);
            return this;
        }

        public ConditionBuilder typeList(List<Integer> type){
            this.typeList = type;
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

        private Message obj;

        public Builder(){
            this.obj = new Message();
        }

        public Builder messageID(Integer messageID){
            this.obj.setMessageID(messageID);
            return this;
        }
        public Builder content(String content){
            this.obj.setContent(content);
            return this;
        }
        public Builder sent(Integer sent){
            this.obj.setSent(sent);
            return this;
        }
        public Builder sentTime(String sentTime){
            this.obj.setSentTime(sentTime);
            return this;
        }
        public Builder type(Integer type){
            this.obj.setType(type);
            return this;
        }
        public Builder senderID(Integer senderID){
            this.obj.setSenderID(senderID);
            return this;
        }
        public Builder receiverID(Integer receiverID){
            this.obj.setReceiverID(receiverID);
            return this;
        }
        public Message build(){return obj;}
    }

}
