/*
 * Copyright (C) 21-Dec-2019 Cricbuzz.com
 * All rights reserved.
 *
 * http://www.cricbuzz.com
 * @author: kshitiz.kapur
 */

package com.flipkart.test.util

import android.widget.ImageView
import com.flipkart.test.models.PictionaryModel
import com.squareup.picasso.Picasso

class GameManager {

    fun loadImage(model: PictionaryModel, imageView: ImageView){
        imagesShown++
        if(model.imageUrl!=null)
            Picasso.get().load(model.imageUrl).into(imageView)
    }

    fun checkAnswer(currentLevel: Int, model: PictionaryModel, answer: String): Int{
        var newLevel = 0
        if(model.answer.equals(answer, true)){
            if(currentLevel == 5)
                newLevel = currentLevel
            else
                newLevel = currentLevel+1
            score++
        }
        else
            newLevel = currentLevel-1

        return newLevel
    }

    var score = 0
    var imagesShown = 0
}