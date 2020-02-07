/*
 * Copyright (C) 21-Dec-2019 Cricbuzz.com
 * All rights reserved.
 *
 * http://www.cricbuzz.com
 * @author: kshitiz.kapur
 */

package com.flipkart.test.util

import com.flipkart.test.models.PictionaryModel

class DataManager {

    fun getMappedData(list: ArrayList<PictionaryModel>): Map<Int, ArrayList<PictionaryModel>>{
        var i = 0
        val map: HashMap<Int, ArrayList<PictionaryModel>> = hashMapOf()
        while(i<list.size){
            val model = list[i]
            if(map.containsKey(model.difficulty)){
                val diffList = map[model.difficulty]
                diffList?.add(model)
                map.put(model.difficulty, diffList!!)
            }else{
                val diffList = arrayListOf<PictionaryModel>()
                diffList.add(model)
                map.put(model.difficulty, diffList!!)
            }
            i++
        }
        return map
    }
}