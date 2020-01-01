package com.example.tabapplication.ui.main.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tabapplication.R
import com.example.tabapplication.ui.main.adapter.Word
import java.lang.AssertionError


class WordQuizActivity : AppCompatActivity() {
    var isCorrect = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_quiz)

        //var wordArray = intent. getParcelableArrayListExtra<ArrayList<Word>>("wordArray")

        var wordArrayList=
            arrayListOf<Word> (
                Word("apple", "사과"),
                Word("orange", "오렌지"),
                Word("grape", "포도")

            )

        val vocab = findViewById<TextView>(R.id.vocab)
        var vocabans = wordArrayList[0].vocabulary
        vocab.text = vocabans

        var alpha: Drawable = findViewById<ImageView>(R.id.image).drawable
        alpha.alpha = 50

        var answer: EditText = findViewById(R.id.answer)
        var str: String? = ""
        str = answer.text.toString()



        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setPositiveButton(
            "OK"
        ) { dialog, id ->
//            Toast.makeText(applicationContext, "OK Click", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, WordQuizActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)


        }

        builder.setTitle("Correct!").setMessage("Go to the next problem")
        val dialog1: AlertDialog = builder.create()
        builder.setTitle("Wrong!").setMessage("The answer is $str")
        val dialog2: AlertDialog = builder.create()



        val submit: ImageButton = findViewById(R.id.submit)
        submit.setOnClickListener{
            isCorrect = vocabans == str

            if(isCorrect){
                dialog1.show()
            }
            else{
                dialog2.show()
            }

        }

    }

}