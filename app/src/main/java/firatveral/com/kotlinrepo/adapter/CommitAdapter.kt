package firatveral.com.kotlinrepo.adapter

import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

import de.hdodenhof.circleimageview.CircleImageView
import firatveral.com.kotlinrepo.R
import firatveral.com.kotlinrepo.model.Commit


class CommitAdapter(private val commitList: List<Commit>) :
    RecyclerView.Adapter<CommitAdapter.MyViewHolder>() {


    override fun getItemCount(): Int {
        return commitList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var authoravatarurl: CircleImageView
        internal var commiturl: TextView
        internal var authorname: TextView
        internal var authordate: TextView


        init {
            authoravatarurl = view.findViewById(R.id.profile_image) as CircleImageView
            commiturl = view.findViewById(R.id.commit_url) as TextView
            authorname = view.findViewById(R.id.commit_name) as TextView
            authordate = view.findViewById(R.id.commit_date) as TextView

        }
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.userlist_item, parent, false)

        return MyViewHolder(itemView)
    }

    override  fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val commit = commitList[position]

        //TODO: date format split after T
        val current = commit.commit!!.author?.date
        val separate1 = current!!.split("T")[0]

        holder.commiturl.setText(commit.commit!!.url)
        holder.authorname.setText(commit.commit!!.author?.name)
        holder.authordate.setText(separate1)


        //TODO: Loading the image using Glide
        val context = holder.authoravatarurl.context
        if (commit.author != null) {
            Glide.with(context).load(commit.author!!.avatarUrl)
                .into(holder.authoravatarurl)
        }

    }
}
