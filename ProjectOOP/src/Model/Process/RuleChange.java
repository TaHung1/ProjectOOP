package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.List;
import java.util.Map;
//
public class RuleChange extends Rules {
    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();
        List<DataOutput> sortedList = sorting.sort(data, 6);
        int tang=0;
        int giam=0;
        int dunggia=0;
        int tangtran=0;
        int giamsan=0;
        for (DataOutput dataOutput : sortedList) {
            double temp = dataOutput.getData().getClose() - dataOutput.getData().getOpen();
            if (temp > 0) {
                tang++;
            } else if (temp < 0) {
                giam++;
            } else {
                dunggia++;
            }

            if (dataOutput.getData().getChangePercent() >= 7) {
                tangtran++;
            }
            if (dataOutput.getData().getChangePercent() <=-7) {
                giamsan++;
            }

        }

        if((tang/giam)>1){
            map.put("code1","tăng");
            map.put("code2","giảm");
            map.put("solan",Integer.toString(tang/giam));
            map.put("soLuong1",Integer.toString(tang));
            map.put("soLuong2",Integer.toString(giam));
        }
        else if ((tang/giam)<1){
            map.put("code1","giảm");
            map.put("code2","tăng");
            map.put("solan",Integer.toString(giam/tang));
            map.put("soLuong1",Integer.toString(giam));
            map.put("soLuong2",Integer.toString(tang));
        }

        map.put("soLuongTang",Integer.toString(tang));
        map.put("soLuongGiam",Integer.toString(giam));
        map.put("soLuongKhongDoi",Integer.toString(dunggia));
        map.put("tangtran",Integer.toString(tangtran));
        map.put("giamsan",Integer.toString(giamsan));

        //phần tử đầu tiên của arr chứa index của phần tử tương ứng của data.
        map.put("tenCaoNhat",sortedList.get(0).getData().getName());
        map.put("tenThapNhat",sortedList.get(sortedList.size()-1).getData().getName());
        map.put("tong",Integer.toString(sortedList.size()));

        //điền tên và lượng thay đổi trong top tăng 5
        for(int i=0;i<sortedList.size();i++) {
            double temp=sortedList.get(i).getData().getClose()-sortedList.get(i).getData().getOpen();
            map.put("name"+(i+1), sortedList.get(i).getData().getName());
            map.put("num"+(i+1), Long.toString((long)(Math.abs(temp)* 1000000)));
        }

        List<DataOutput> sortedReverseList = sorting.sort(data,6,sortedList.size(),true);
        for(int i=0;i<sortedReverseList.size();i++) {
            double temp=sortedReverseList.get(i).getData().getClose()-sortedReverseList.get(i).getData().getOpen();
            map.put("rname"+(i+1), sortedReverseList.get(i).getData().getName());
            map.put("rnum1", Long.toString((long)((Math.abs(temp)) * 1000000)));

        }

        return map;
    }








//        //ArrayList này để chứa các đối tương Rules được tạo ra
//        List<Rules> arr = new LinkedList<>();
//
//        //hàm này dùng để tạo ra các đối tượng Rules và thêm nó vào trong ArrayList của lớp Rules
//
//        //phương thức dùng để truyền giá trị cho thuộc tính của đối tượng và đưa đối tượng vào list.
//        for (int i=0;i<(data.size());i++){
//            double tmp = data.get(i).getClose()-data.get(i).getOpen();
//            double temp=(double) Math.round(((data.get(i).getClose())/(data.get(i).getOpen())-1)*10000)/100;
//            arr.add(new Rules(i,tmp,temp));
//        }
//        //Hàm này dùng để sắp xếp lại list và sau đó truyền các thông số vào map
//
//        int Tang=0;
//        int Giam=0;
//        int KhongDoi=0;
//        int TangTran=0;
//        int GiamSan=0;
//        //sắp xếp các đối tượng trong String arr theo thứ tự giảm dần về change
//        arr.sort(new SortByChange());
//        //Cứ mỗi vòng lặp thì sẽ đếm được số tăng, giảm,không đổi.
//        for (int j=0;j< arr.size();j++){
//            if (arr.get(j).getValueChange()>0){
//                Tang++;
//            }
//            else if(arr.get(j).getValueChange()<0){
//                Giam++;
//            }
//            else {
//                KhongDoi++;
//            }
//
//            if (Math.round(arr.get(j).getPercentChange()) ==7 ){ TangTran++;}
//            else if (Math.round(arr.get(j).getPercentChange()) ==-7){GiamSan++;}
//
//
//        }
//
//        if((Tang/Giam)>1){
//            map.put("code1","tăng");
//            map.put("code2","giảm");
//            map.put("solan",Integer.toString(Tang/Giam));
//            map.put("soLuong1",Integer.toString(Tang));
//            map.put("soLuong2",Integer.toString(Giam));
//        }
//        else if ((Tang/Giam)<1){
//            map.put("code1","giảm");
//            map.put("code2","tăng");
//            map.put("solan",Integer.toString(Giam/Tang));
//            map.put("soLuong1",Integer.toString(Giam));
//            map.put("soLuong2",Integer.toString(Tang));
//        }
//
//        //truyền key và value tương ứng vào map.
//        map.put("soLuongTang",Integer.toString(Tang));
//        map.put("soLuongGiam",Integer.toString(Giam));
//        map.put("soLuongKhongDoi",Integer.toString(KhongDoi));
//        map.put("tangtran",Integer.toString(TangTran));
//        map.put("giamsan",Integer.toString(GiamSan));
//
//
//        //phần tử đầu tiên của arr chứa index của phần tử tương ứng của data.
//        map.put("tenCaoNhat",data.get(arr.get(0).getIndex()).getName());
//        map.put("tenThapNhat",data.get(arr.get(arr.size()-1).getIndex()).getName());
//        map.put("tong",Integer.toString(arr.size()));
//
//        //điền tên và lượng thay đổi trong top tăng 5
//        for(int i=0;i<arr.size();i++) {
//            map.put("name"+(i+1), data.get(arr.get(i).getIndex()).getName());
//            map.put("num"+(i+1), Double.toString(arr.get(0).getValueChange() * 1000));
//        }
//
//        arr.sort(new SortByReverseChange());
//        //điền tên và lượng thay đổi trong top giảm 5
//        for(int i=0;i<arr.size();i++) {
//            map.put("rname"+(i+1), data.get(arr.get(i).getIndex()).getName());
//            map.put("rnum1", Double.toString((Math.abs(arr.get(i).getValueChange())) * 1000));
//
//        }
//
//
//        return map;
//    }

}
