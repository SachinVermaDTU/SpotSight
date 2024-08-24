package com.example.spotsight.domain

import android.graphics.Bitmap
import com.example.spotsight.data.Classification

interface LandmarkClassifier {
    fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}