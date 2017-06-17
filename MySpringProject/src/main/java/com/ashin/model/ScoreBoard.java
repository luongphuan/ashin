package com.ashin.model;

/**
 * Created by anluo on 4/16/2017.
 */
public class ScoreBoard {
    int idSubject,idClass,idStudent;
    int oralScore,fifteenMinutesScore;
    int fortyfiveMinutesScore,finalScore,totalScore;
    int semester;

    public ScoreBoard(int idSubject, int idClass, int idStudent, int oralScore, int fifteenMinutesScore, int fortyfiveMinutesScore, int finalScore, int totalScore, int semester) {
        this.idSubject = idSubject;
        this.idClass = idClass;
        this.idStudent = idStudent;
        this.oralScore = oralScore;
        this.fifteenMinutesScore = fifteenMinutesScore;
        this.fortyfiveMinutesScore = fortyfiveMinutesScore;
        this.finalScore = finalScore;
        this.totalScore = totalScore;
        this.semester = semester;
    }
    public ScoreBoard(){}
    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getOralScore() {
        return oralScore;
    }

    public void setOralScore(int oralScore) {
        this.oralScore = oralScore;
    }

    public int getFifteenMinutesScore() {
        return fifteenMinutesScore;
    }

    public void setFifteenMinutesScore(int fifteenMinutesScore) {
        this.fifteenMinutesScore = fifteenMinutesScore;
    }

    public int getFortyfiveMinutesScore() {
        return fortyfiveMinutesScore;
    }

    public void setFortyfiveMinutesScore(int fortyfiveMinutesScore) {
        this.fortyfiveMinutesScore = fortyfiveMinutesScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semeter) {
        this.semester = semeter;
    }
}
