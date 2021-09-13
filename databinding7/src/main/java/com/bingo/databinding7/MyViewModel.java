package com.bingo.databinding7;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by ing on 2021/9/13
 */
public class MyViewModel extends ViewModel {
    public MutableLiveData<Integer> aTeamScore;
    public MutableLiveData<Integer> bTeamScore;
    private Integer aLast;
    private Integer bLast;

    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore==null){
            aTeamScore=new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore==null){
            bTeamScore=new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }
    public void aTeamScore(int i){
        saveLastScore();
        aTeamScore.setValue(aTeamScore.getValue()+i);
    }
    public void bTeamScore(int i){
        saveLastScore();
        bTeamScore.setValue(bTeamScore.getValue()+i);
    }
    public void undo(){
        aTeamScore.setValue(aLast);
        bTeamScore.setValue(bLast);
    }
    public void reset(){
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }
    //记录上一次的分数
    private void saveLastScore(){
        this.aLast =aTeamScore.getValue();
        this.bLast = bTeamScore.getValue();
    }
}
