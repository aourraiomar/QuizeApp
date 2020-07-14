package com.example.quizerev.Model;

public class Quize {
    public  int image;
    public String question;
    public  String quize1;
    public  String quize2;
    public  String quize3;
    public  String quize4;
    public  int answertrue;

    public Quize(int image, String question, String quize1, String quize2, String quize3, String quize4, int answertrue) {
        this.image = image;
        this.question = question;
        this.quize1 = quize1;
        this.quize2 = quize2;
        this.quize3 = quize3;
        this.quize4 = quize4;
        this.answertrue = answertrue;
    }
    public Quize(int image, String question, String quiz1, String quiz2, String quiz3, int answertrue) {
        this.image = image;
        this.question = question;
        this.quize1 = quiz1;
        this.quize2 = quiz2;
        this.quize3 = quiz3;
        this.answertrue = answertrue;
    }

    public Quize(int image, String question, String quiz1, String quiz2, int answertrue) {
        this.image = image;
        this.question = question;
        this.quize1 = quiz1;
        this.quize2 = quiz2;
        this.answertrue = answertrue;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuize1() {
        return quize1;
    }

    public void setQuize1(String quize1) {
        this.quize1 = quize1;
    }

    public String getQuize2() {
        return quize2;
    }

    public void setQuize2(String quize2) {
        this.quize2 = quize2;
    }

    public String getQuize3() {
        return quize3;
    }

    public void setQuize3(String quize3) {
        this.quize3 = quize3;
    }

    public String getQuize4() {
        return quize4;
    }

    public void setQuize4(String quize4) {
        this.quize4 = quize4;
    }

    public int getAnswertrue() {
        return answertrue;
    }

    public void setAnswertrue(int answertrue) {
        this.answertrue = answertrue;
    }
}
