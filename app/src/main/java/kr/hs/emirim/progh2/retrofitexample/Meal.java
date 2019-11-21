package kr.hs.emirim.progh2.retrofitexample;

import java.util.List;

class Meal {
    private List<String> 조식;
    private List<String> 중식;
    private List<String> 석식;

    public List<String> get조식(){
        return 조식;
    }

    public List<String> get중식(){
        return 중식;
    }

    public List<String> get석식(){
        return 석식;
    }
}
