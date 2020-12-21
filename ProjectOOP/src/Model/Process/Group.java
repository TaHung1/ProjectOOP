package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.*;


public abstract class Group {
    protected Map<String, String> eachMap;
    private List<String> sentences;
    private Random random;
    private String output;


    public Group() {
        sentences = new ArrayList<>();
        random = new Random();
        eachMap = new HashMap<>();
    }


    //->Phương thức này dùng để đưa các mẫu câu của cùng 1 nhóm (chưa xử lí) vào 1 list để lúc sau random câu để xử lí.
    protected void addGroupSentences(String stc) {
        this.sentences.add(stc);
    }

    public String replaceVariable(String key) {
        return null;

    }

    //->Phương thức này với ý tưởng là thay thế biến trong dấu ngoặc (ví dụ: <abc>) thành giá trị phù hợp.
    //tách phần tử ra 3 phần (trước "<", sau ">" và giá trị ở giữa).
    private String swapWord(String word) {
        int first = word.indexOf("<");
        int last = word.indexOf(">", first);
        if ((first == -1) || (last == -1)) {
            return word;
        }
        String prefix = word.substring(0, first);
        String suffix = word.substring(last + 1);
        String sub = replaceVariable(word.substring(first + 1, last));
        return prefix + sub + suffix;
    }

    //->Chia câu thành các phần nhỏ hơn (cụ thể là cứ mỗi giữa 2 khoảng trống sẽ là 1 word)
    //sau khi xử lí hết các phần tử word của câu thì ghép chúng lại thành câu hoàn chỉnh.
    public String divideSentences(String sentence) {
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            result.append(swapWord(word)).append(" ");
        }
        return result.toString();
    }

    //hàm này dùng để random ra câu để xử lí
    public String randomSentence(List<String> sentences) {
        int index = random.nextInt(sentences.size());
        return sentences.get(index);
    }

    //hàm này để lấy ra câu sau khi đã xử lí hoàn tất
    public String getOutput() {
        this.output = divideSentences(randomSentence(this.sentences));
        return output;
    }

    public String getOutput(List<String> list) {
        return null;
    }

    //hàm này để override lại
    public abstract String begin(List<DataOutput> data);
    //public abstract List<String> begin(ArrayList<DataInput> data,String name);


}