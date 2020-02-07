/*
 * Copyright (C) 21-Dec-2019 Cricbuzz.com
 * All rights reserved.
 *
 * http://www.cricbuzz.com
 * @author: kshitiz.kapur
 */

package com.flipkart.test.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.flipkart.test.R
import com.flipkart.test.models.PictionaryModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View){
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("data", loadLocalData())
        startActivity(intent)
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val input: InputStream = assets.open("pictionary.json")
            val size: Int = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        Log.d("DATA",json)
        return json
    }

    fun loadLocalData(): ArrayList<PictionaryModel>{
        var list: ArrayList<PictionaryModel>?=null
        val obj: String = loadJSONFromAsset()!!
        val type = object : TypeToken<List<PictionaryModel>>() {}.type
        list = Gson().fromJson<ArrayList<PictionaryModel>>(obj, type)
        Log.d("LIST",list.toString())
        return list
    }
}
