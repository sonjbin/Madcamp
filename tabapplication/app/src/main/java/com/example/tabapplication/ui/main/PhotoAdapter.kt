import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.tabapplication.R
import com.example.tabapplication.ui.main.GalleryFragment
import com.example.tabapplication.ui.main.Photo
import kotlinx.android.synthetic.main.photo_entry.view.*

class PhotoAdapter: BaseAdapter {

    var photosList = ArrayList<Photo>()
    var context: Context? = null
    var fragment: GalleryFragment? = null
    constructor(context: Context?, fragment: GalleryFragment?, photosList: ArrayList<Photo>) : super() {
        this.context = context
        this.fragment = fragment
        this.photosList = photosList
    }

    override fun getCount(): Int {
        return photosList.size
    }

    override fun getItem(position: Int): Photo {
        return photosList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val photo = this.photosList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var photoView = inflator.inflate(R.layout.photo_entry, null)
        photoView.img.setImageResource(photo.image!!)
        photoView.textName.text = photo.name!!

        return photoView
    }

}
