package ProjectOOP.src.Model;

import java.util.LinkedList;
import java.util.List;

public class DataFileOutput {
    private List<DataOutput> data;
    private TagManager tagManager;
    // Todo: Thêm các hàm để xử lý chuyển đổi các câu văn thành 1 đoạn văn ngắn
    // Todo: Thêm các hàm phục vụ mục tra cứu, tìm kiểm cho Controller

    public DataFileOutput() {
        data = new LinkedList<DataOutput>();
        tagManager = new TagManager();
    }

    public DataFileOutput(List<DataOutput> data) {
        this.data = data;
        tagManager = new TagManager();
    }

    public DataFileOutput(List<DataOutput> data, TagManager tagManager) {
        this.data = data;
        this.tagManager = tagManager;
    }

    public List<DataOutput> getData() {
        return data;
    }

    public void setData(List<DataOutput> data) {
        this.data = data;
    }

    public TagManager getTagManager() {
        return tagManager;
    }

    public void setTagManager(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    //Thêm 1 Output vào List
    public void addData(DataOutput dO){
        data.add(dO);
    }

    //Nhận 1 request từ Controler và trả về 1 List Output phù hợp
    public List<DataOutput> find(String request){
        if(!getTagManager().isHaveThisTag(request)){
            return null;
            //respond to View: Không tìm thấy dữ liệu
        }
        List<DataOutput> respond = new LinkedList<DataOutput>();
        for(DataOutput output: data){
            if(output.getTags().isHaveThisTag(request)){
                respond.add(output);
            }
        }
        return respond;
    }
    // trả về đoạn văn phù hợp lên View
    public String respond(String request){
        List<DataOutput> dataOutputs = find(request);
        Tag tag = getTagManager().findTag(request);
        String respondParagrahp="";
        switch (tag.getTagType()) {
            case "name":
                //
                break;
            case "change":
                //
                break;
            case "ranking":
                //
                break;
        }
        return respondParagrahp;
    }


    //Debug
    public void Debug(){
        for (DataOutput datum : data) {
            datum.Debug();
        }
        tagManager.Debug();
    }

}
