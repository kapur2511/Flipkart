/*
 * Copyright (C) 21-Dec-2019 Cricbuzz.com
 * All rights reserved.
 *
 * http://www.cricbuzz.com
 * @author: kshitiz.kapur
 */

package com.flipkart.test.models

import java.io.Serializable

data class PictionaryModel(val id: Int,
                           val imageUrl: String,
                           val difficulty: Int,
                           val answer: String): Serializable