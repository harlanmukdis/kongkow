package suryakancana.kongkow.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import java.io.File


/**
 * Created by LIMS on 09/12/2017.
 */
class CameraUtils {
    private var lastCameraImageSaved = Uri.Builder().build()

    @Throws(Exception::class)
    fun getImageUri(data: Intent?): Uri? {
        val imageUri: Uri?
        if (data == null) {
            imageUri = lastCameraImageSaved
        } else {
            imageUri = data.data
        }
        return imageUri
    }

    fun getImageFromGalleryCamera(context: Context): Intent {
        // Determine Uri of camera image to save.
        val root = File(
                Environment.getExternalStorageDirectory().toString() + File.separator + "dianta/camera" + File.separator)
        root.mkdirs()
        val fname = "dianta-" + System.currentTimeMillis() + ".jpg"
        val sdImageMainDirectory = File(root, fname)
        val outputFileUri = Uri.fromFile(sdImageMainDirectory)

        // camera
        val cameraIntents = ArrayList<Intent>()
        val captureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val lPackageManager = context.getPackageManager()
        val listCam = lPackageManager.queryIntentActivities(captureIntent, 0)
        for (rInfo in listCam) {
            val packageName = rInfo.activityInfo.packageName
            val lIntent = Intent(captureIntent)
            lIntent.component = ComponentName(rInfo.activityInfo.packageName, rInfo.activityInfo.name)
            lIntent.`package` = packageName
            //save camera result to external storage
            lIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
            cameraIntents.add(lIntent)
        }

        //ugly hacks for camera helper
        lastCameraImageSaved = outputFileUri

        // gallery
        val galleryIntent = Intent()
        galleryIntent.type = "image/*"
        galleryIntent.action = Intent.ACTION_PICK

        val chooserIntent = Intent.createChooser(galleryIntent, "Pilih Sumber")
        chooserIntent
                .putExtra(Intent.EXTRA_INITIAL_INTENTS, cameraIntents.toTypedArray())

        return chooserIntent
    }
}