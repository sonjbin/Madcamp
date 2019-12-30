//package com.example.tabapplication.ui.main.fragment
//
//import android.Manifest.permission.CAMERA
//import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
//import android.content.ContentResolver
//import android.content.Intent
//import android.database.Cursor
//import android.net.Uri
//import android.os.Bundle
//import android.provider.MediaStore
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.example.tabapplication.R
//import com.gun0912.tedpermission.PermissionListener
//import com.gun0912.tedpermission.TedPermission
//import java.io.File
//import java.util.*
//
//
//private const val PICK_FROM_ALBUM = 1
//private var tempFile: File? = null
//
//class GetImageFragment : Fragment(){
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        var view: View = inflater.inflate(
//            R.layout.fragment_gallery,
//            container,
//            false
//        )
//        tedPermission()
//        return view
//    }
//
//
//    private fun tedPermission(){
//        var permissionListener: PermissionListener = object: PermissionListener{
//            override fun onPermissionGranted() {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onPermissionDenied(deniedPermissions: ArrayList<String>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        }
//
//        TedPermission.with(context)
//            .setPermissionListener(permissionListener)
//            .setRationaleMessage(resources.getString(R.string.permission_2))
//            .setDeniedMessage(resources.getString(R.string.permission_1))
//            .setPermissions(WRITE_EXTERNAL_STORAGE, CAMERA)
//            .check()
//    }
//    private fun goToAlbum(){
//        val intent: Intent = Intent(Intent.ACTION_PICK)
//        intent.type = MediaStore.Images.Media.CONTENT_TYPE
//        startActivityForResult(intent, PICK_FROM_ALBUM )
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if(requestCode == PICK_FROM_ALBUM){
//            val photoUri: Uri? = data!!.data
//            var cursor: Cursor? = null
//
//            try{
//                val proj =
//                    arrayOf(MediaStore.Images.Media.DATA)
//
//                assert(photoUri != null)
//                var contentResolver: ContentResolver = object: ContentResolver()
//                cursor = photoUri?.let { contentResolver.query(it, proj, null, null, null) }
//
//                assert(cursor != null)
//                val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
//
//                cursor.moveToFirst()
//
//                tempFile = File(cursor.getString(column_index))
//            }
//            finally {
//                cursor?.close()
//            }
//            //setImage();
//        }
//    }
//
//}