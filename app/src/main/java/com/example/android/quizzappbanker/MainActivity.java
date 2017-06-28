package com.example.android.quizzappbanker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quizzappbanker.R.id.banks;
import static com.example.android.quizzappbanker.R.id.friends;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int question1 = 0;
    int question2 = 0;
    int question3 = 0;
    int question4 = 0;
    int question5 = 0;
    int question6 = 0;
    CharSequence mesaj;
    String verifAnsw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is calculating the score for the first question.
     */
    public int firstQuestion() {
        question1 = 0;
        CheckBox withCard = (CheckBox) findViewById(R.id.creditCard);
        boolean hasCreditCard = withCard.isChecked();
        CheckBox withAccount = (CheckBox) findViewById(R.id.currentAcc);
        boolean hasCurrentAcc = withAccount.isChecked();
        CheckBox withConsumerLoan = (CheckBox) findViewById(R.id.consumerLoan);
        boolean hasConsumerLoan = withConsumerLoan.isChecked();
        CheckBox withMortgageLoan = (CheckBox) findViewById(R.id.mortgageLoan);
        boolean hasMortgageLoan = withMortgageLoan.isChecked();
        CheckBox withInternetBanking = (CheckBox) findViewById(R.id.internetBanking);
        boolean hasInternetBanking = withInternetBanking.isChecked();
        if (hasCreditCard) {
            question1 = question1 + 1;
        }
        if (hasCurrentAcc) {
            question1 = question1 + 1;
        }
        if (hasConsumerLoan) {
            question1 = question1 + 1;
        }
        if (hasMortgageLoan) {
            question1 = question1 + 1;
        }
        if (hasInternetBanking) {
            question1 = question1 + 1;
        }
        return question1;
    }

    /**
     * This method is calculating the score for the second question.
     */
    public int secondQuestion() {
        question2 = 0;
        CheckBox withPension = (CheckBox) findViewById(R.id.pensionFound);
        boolean hasPension = withPension.isChecked();
        CheckBox withStock = (CheckBox) findViewById(R.id.stock);
        boolean hasStock = withStock.isChecked();
        CheckBox withNews = (CheckBox) findViewById(R.id.finNews);
        boolean hasFinNews = withNews.isChecked();
        if (hasPension) {
            question2 = question2 + 1;
        }
        if (hasStock) {
            question2 = question2 + 3;
        }
        if (hasFinNews) {
            question2 = question2 + 2;
        }
        return question2;
    }

    /**
     * This method is calculating the score for the third question.
     */

    public int thirdQuestion() {
        EditText answer = (EditText) findViewById(R.id.answer);
        double answ = Double.parseDouble(answer.getText().toString());

        if (answ > 125) {
            question3 = 3;
        } else {
            question3 = 0;
        }
        return question3;
    }

    /**
     * This method is calculating the score for the fourth question.
     */
    public int fourthQuestion() {
        question4 = 0;
        CheckBox fromFriends = (CheckBox) findViewById(friends);
        boolean friends = fromFriends.isChecked();
        CheckBox fromBanks = (CheckBox) findViewById(banks);
        boolean banks = fromBanks.isChecked();
        CheckBox loanCompanies = (CheckBox) findViewById(R.id.loan_companies);
        boolean loanComp = loanCompanies.isChecked();
        CheckBox otherPersons = (CheckBox) findViewById(R.id.other_persons);
        boolean other = otherPersons.isChecked();
        if (friends) {
            question4 = question4 + 2;
        }
        if (banks) {
            question4 = question4 + 3;
        }
        if (loanComp) {
            question4 = question4 + 1;
        }
        return question4;
    }

    /**
     * This method is calculating the score for the fifth question.
     */
    public void onInvestment(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.stocks:
                if (checked)
                    question5 = 0;
                break;
            case R.id.bonds:
                if (checked)
                    question5 = 3;
                break;
            case R.id.know:
                if (checked)
                    question5 = 0;
                break;
        }
    }

    /**
     * This method is calculating the score for the sixth question.
     */
    public void onFinDecision(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.shopping:
                if (checked)
                    question6 = 0;
                break;
            case R.id.deposit:
                if (checked)
                    question6 = 2;
                break;
            case R.id.cash:
                if (checked)
                    question6 = 1;
                break;
            case R.id.investments:
                if (checked)
                    question6 = 3;
                break;
            case R.id.no_extra:
                if (checked)
                    question6 = 0;
                break;
        }
    }

    /**
     * This method is called when the Submit Answers button is clicked.
     */
    public void submitAnswers(View view) {

        EditText answer = (EditText) findViewById(R.id.answer);
        verifAnsw = answer.getText().toString();
        if (TextUtils.isEmpty(verifAnsw)) {
            Toast.makeText(this, getString(R.string.verif_answ), Toast.LENGTH_LONG).show();
            return;
        }

        EditText text = (EditText) findViewById(R.id.name);
        String name = text.getText().toString().trim();

        score = firstQuestion() + secondQuestion() + thirdQuestion() + fourthQuestion() + question5 + question6;
        if (score < 10) {
            mesaj = name + ", " + getString(R.string.your_score) + " : " + score + " " + getString(R.string.points) + " 26 ! " + getString(R.string.improve) + " !";
            afisareMesaj();
        }
        if (score >= 10 && score <= 20) {
            mesaj = name + ", " + getString(R.string.your_score) + " : " + score + " " + getString(R.string.points) + " 26 ! " + getString(R.string.about) + " !";
            afisareMesaj();
        }
        if (score > 20) {
            mesaj = name + ", " + getString(R.string.your_score) + " : " + score + " " + getString(R.string.points) + " 26 ! " + getString(R.string.congrats) + " ! " + getString(R.string.already) + " !";
            afisareMesaj();
        }
        score = 0;
    }

    public void afisareMesaj() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, mesaj, duration);
        toast.show();
    }
}
