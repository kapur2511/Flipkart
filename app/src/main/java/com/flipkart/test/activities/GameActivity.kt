/*
 * Copyright (C) 21-Dec-2019 Cricbuzz.com
 * All rights reserved.
 *
 * http://www.cricbuzz.com
 * @author: kshitiz.kapur
 */

package com.flipkart.test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.flipkart.test.R
import com.flipkart.test.models.PictionaryModel
import com.flipkart.test.util.DataManager
import com.flipkart.test.util.GameManager
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        imageView = findViewById(R.id.imgDetail)
        editText = findViewById(R.id.eTxtAnswer)
        list = intent.getSerializableExtra("data") as ArrayList<PictionaryModel>
        if(list?.isNotEmpty()!!){
            dataSet = DataManager().getMappedData(list!!)
        }
        loadNext()
    }

    fun submitClick(view: View){
        currentDifficulty = gameManager.checkAnswer(currentDifficulty, currentPictionaryModel!!, editText?.text.toString())
        if(currentDifficulty > 0)
            loadNext()
        else {
            Toast.makeText(this, "GAME OVER", Toast.LENGTH_LONG).show()
            onBackPressed()
        }
    }

    private fun loadNext(){
        editText?.setText("")
        randomNumber = Random.nextInt(0, dataSet[currentDifficulty]!!.size-1)
        currentPictionaryModel = dataSet.get(currentDifficulty)?.removeAt(randomNumber)
        if(gameManager.imagesShown<5)
            gameManager.loadImage(currentPictionaryModel!!, imageView!!)
        else{
            Toast.makeText(this, "YOUR SCORE: ${gameManager.score}", Toast.LENGTH_LONG).show()
            onBackPressed()
        }
    }

    var editText: EditText?=null
    var imageView: ImageView?=null
    private val gameManager: GameManager = GameManager()
    private var list: ArrayList<PictionaryModel>?= null
    private var currentPictionaryModel:PictionaryModel?=null
    private var dataSet: Map<Int, ArrayList<PictionaryModel>> = emptyMap()
    private var currentDifficulty = 3
    private var randomNumber = 0
}
