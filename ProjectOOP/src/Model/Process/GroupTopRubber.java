package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupTopRubber extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ở nhóm ngành cao su, <nameC1> đang dẫn đầu với việc <Clink1> <level1> <numC1> đồng, ngay sau đó là <nameC2> khi <Clink2> <level2> <numC2> đồng.");
        addGroupSentences("Về nhóm cao su thì <nameC1> đang dẫn đầu khi <Clink1> <level1> <numC1> đồng, ngay sau đó là <nameC2> <Clink2> <level2> <numC2> đồng.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleRubber()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top thay đổi giá ở nhóm Cao Su.