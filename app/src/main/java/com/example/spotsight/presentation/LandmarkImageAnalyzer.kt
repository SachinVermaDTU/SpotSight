package com.example.spotsight.presentation


import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.spotsight.data.Classification
import com.example.spotsight.data.FrameDimens
import com.example.spotsight.data.ImageDimens
import com.example.spotsight.domain.LandmarkClassifier

class LandmarkImageAnalyzer(
    private val classifier: LandmarkClassifier,
    private val onResults: (List<Classification>) -> Unit
): ImageAnalysis.Analyzer {

    private var frameSkipCounter = 0

    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter % FrameDimens.framesPerSecond == 0) {
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image
                .toBitmap()
                .centerCrop(ImageDimens.width, ImageDimens.height)

            val results = classifier.classify(bitmap, rotationDegrees)
            onResults(results)
        }
        frameSkipCounter++

        image.close()
    }
}