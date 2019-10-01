package firatveral.com.kotlinrepo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

import de.hdodenhof.circleimageview.CircleImageView
import firatveral.com.kotlinrepo.R
import firatveral.com.kotlinrepo.model.Commit


class CommitAdapter(private val userList: List<Commit>) :
    RecyclerView.Adapter<CommitAdapter.MyViewHolder>() {


    override fun getItemCount(): Int {
        return userList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var user_profile_avatar: CircleImageView
        internal var username: TextView
        internal var user_state: TextView
        internal var user_date: TextView


        init {
            user_profile_avatar = view.findViewById(R.id.profile_image) as CircleImageView
            username = view.findViewById(R.id.user_name) as TextView
            user_state = view.findViewById(R.id.userstate) as TextView
            user_date = view.findViewById(R.id.userdate) as TextView

        }
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.userlist_item, parent, false)

        return MyViewHolder(itemView)
    }

    override  fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]

        holder.username.setText(user.commit!!.url)
        holder.user_state.setText(user.commit!!.author?.name)
        holder.user_date.setText(user.commit!!.author?.date)


        //Loading the image using Glide
        val context = holder.user_profile_avatar.context
        if (user.author != null) {
            Glide.with(context).load(user.author!!.avatarUrl)
                .into(holder.user_profile_avatar)
        }

    }
}
