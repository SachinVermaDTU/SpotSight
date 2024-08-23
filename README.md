# SpotSight

**SpotSight** is an Android application that uses an onboard TensorFlow Lite (TFLite) model to perform image classification. This repository is designed to be flexible, allowing users to easily replace the default TFLite model with their own custom classification model.

## Features

- Easy integration with custom TFLite models.
- Flexible image classification with different models.
- Simple, modular code structure.

## Getting Started

### Prerequisites

- Android Studio
- Basic knowledge of Android development and TFLite

### Adding Your TFLite Model

To replace the existing model with your own:

1. **Prepare Your TFLite Model**:
   - Ensure your model is in the `.tflite` format.
   - Make sure your model's input and output dimensions match the expected format in the app.

2. **Replace the Model File**:
   - Navigate to the `assets` directory in the project.
   - Replace `landmarks.tflite` with your own `.tflite` model file.
   - Update the label file if necessary to match the classes your model predicts.
   - > **Note**: Some users might encounter an issue in Android Studio where they are unable to paste the TFLite model  
       > If this happens, manually navigate to the project folder on your system:  
       > `SpotSight -> app -> src -> main -> assets`, and paste your `.tflite` model file there.


3. **Modify the Code if Needed**:
   - Open `TfLiteLandmarkClassifier.kt`.
   - Update the image processing pipeline if your model's input size differs from the default.
   - Adjust any post-processing steps to align with your model's output format.
     
### Customizing Image Dimensions

If your TFLite model requires different input dimensions, you can easily adjust the image dimensions used for classification:

1. Open the `ImageDimens` object in the `data` package.
2. Set the `width` and `height` properties to the required dimensions for your model.

```kotlin
object ImageDimens {
    var width: Int = 224 // Set your desired width
    var height: Int = 224 // Set your desired height
}
