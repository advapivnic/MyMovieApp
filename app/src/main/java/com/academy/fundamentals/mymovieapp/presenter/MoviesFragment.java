package com.academy.fundamentals.mymovieapp.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.academy.fundamentals.mymovieapp.R;
import com.academy.fundamentals.mymovieapp.list.OnMovieClickListener;
import com.academy.fundamentals.mymovieapp.list.RecyclerViewAdapter;
import com.academy.fundamentals.mymovieapp.model.MovieModel;
import com.academy.fundamentals.mymovieapp.model.MoviesContent;
import com.academy.fundamentals.mymovieapp.presenter.background.BGServiceActivity;
import com.academy.fundamentals.mymovieapp.presenter.threads.AsyncTaskActivity;
import com.academy.fundamentals.mymovieapp.presenter.threads.ThreadsHandlerActivity;

public class MoviesFragment extends Fragment  implements OnMovieClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent activityToLaunch = null;
        if (id == R.id.menu_asyntask) {
            activityToLaunch = new Intent(getActivity(), AsyncTaskActivity.class);

        } else if (id == R.id.menu_threadhandler) {
            activityToLaunch = new Intent(getActivity(), ThreadsHandlerActivity.class);
        }
        else if (id == R.id.menu_service) {
            activityToLaunch = new Intent(getActivity(), BGServiceActivity.class);
        }
        if (activityToLaunch != null) {
            getActivity().startActivity(activityToLaunch);
        }

        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        if (savedInstanceState == null) {
            loadMovies();
        }

        RecyclerView mRecyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.Adapter mAdapter = new RecyclerViewAdapter(MoviesContent.MOVIES, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private void loadMovies() {
        MoviesContent.clear();

        MovieModel movie1 = new MovieModel();
        MovieModel movie2 = new MovieModel();
        MovieModel movie3 = new MovieModel();
        MovieModel movie4 = new MovieModel();
        MovieModel movie5 = new MovieModel();
        MovieModel movie6 = new MovieModel();
        MovieModel movie7 = new MovieModel();
        MovieModel movie8 = new MovieModel();
        MovieModel movie9 = new MovieModel();

        movie1.setName("Jurassic World - Fallen Kingdom");
        movie2.setName("The Meg");
        movie3.setName("The First Purge");
        movie4.setName("Deadpool 2");
        movie5.setName("Black Panther");
        movie6.setName("Ocean's Eight");
        movie7.setName("Interstellar");
        movie8.setName("Thor - Ragnarok");
        movie9.setName("Guardians of the Galaxy");

        movie1.setImageRes(R.drawable.jurassic_world_fallen_kingdom);
        movie2.setImageRes(R.drawable.the_meg);
        movie3.setImageRes(R.drawable.the_first_purge);
        movie4.setImageRes(R.drawable.deadpool_2);
        movie5.setImageRes(R.drawable.black_panther);
        movie6.setImageRes(R.drawable.ocean_eight);
        movie7.setImageRes(R.drawable.interstellar);
        movie8.setImageRes(R.drawable.thor_ragnarok);
        movie9.setImageRes(R.drawable.guardians_of_the_galaxy);

        movie1.setBgImageRes(R.drawable.jurassic_world_back);
        movie2.setBgImageRes(R.drawable.the_meg_back);
        movie3.setBgImageRes(R.drawable.the_first_purge_back);
        movie4.setBgImageRes(R.drawable.deadpool_2_back);
        movie5.setBgImageRes(R.drawable.black_panther_back);
        movie6.setBgImageRes(R.drawable.ocean_eight_back);
        movie7.setBgImageRes(R.drawable.interstellar_back);
        movie8.setBgImageRes(R.drawable.thor_ragnarok_back);
        movie9.setBgImageRes(R.drawable.guardians_of_the_galaxy_back);

        movie1.setTrailerUrl("https://www.youtube.com/watch?v=vn9mMeWcgoM)");
        movie2.setTrailerUrl("https://www.youtube.com/watch?v=bsLk0NPRFAc");
        movie3.setTrailerUrl("https://www.youtube.com/watch?v=UL29y0ah92w");
        movie4.setTrailerUrl("https://www.youtube.com/watch?v=20bpjtCbCz0");
        movie5.setTrailerUrl("https://www.youtube.com/watch?v=xjDjIWPwcPU");
        movie6.setTrailerUrl("https://www.youtube.com/watch?v=n5LoVcVsiSQ");
        movie7.setTrailerUrl("https://www.youtube.com/watch?v=zSWdZVtXT7E");
        movie8.setTrailerUrl("https://www.youtube.com/watch?v=ue80QwXMRHg");
        movie9.setTrailerUrl("https://www.youtube.com/watch?v=2LIQ2-PZBC8");

        movie1.setDate("2018-06-06");
        movie2.setDate("2018-08-09");
        movie3.setDate("2018-07-04");
        movie4.setDate("2018-05-15");
        movie5.setDate("2018-02-13");
        movie6.setDate("2018-06-07");
        movie7.setDate("2014-11-05");
        movie8.setDate("2017-10-25");
        movie9.setDate("2014-07-30");

        movie1.setOverview("Three years after the demise of Jurassic World, a volcanic eruption threatens the remaining dinosaurs on the isla Nublar, so Claire Dearing, the former park manager, recruits Owen Grady to help prevent the extinction of the dinosaurs once again");
        movie2.setOverview("A deep sea submersible pilot revisits his past fears in the Mariana Trench, and accidentally unleashes the seventy foot ancestor of the Great White Shark believed to be extinct");
        movie3.setOverview("To push the crime rate below one percent for the rest of the year, the New Founding Fathers of America test a sociological theory that vents aggression for one night in one isolated community. But when the violence of oppressors meets the rage of the others, the contagion will explode from the trial-city borders and spread across the nation");
        movie4.setOverview("Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life");
        movie5.setOverview("King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war");
        movie6.setOverview("Debbie Ocean, a criminal mastermind, gathers a crew of female thieves to pull off the heist of the century at New York's annual Met Gala");
        movie7.setOverview("Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage");
        movie8.setOverview("Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela");
        movie9.setOverview("Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser");


        MoviesContent.addMovie(movie1);
        MoviesContent.addMovie(movie2);
        MoviesContent.addMovie(movie3);
        MoviesContent.addMovie(movie4);
        MoviesContent.addMovie(movie5);
        MoviesContent.addMovie(movie6);
        MoviesContent.addMovie(movie7);
        MoviesContent.addMovie(movie8);
        MoviesContent.addMovie(movie9);
    }

    @Override
    public void onMovieClicked(int itemPosition) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity)getActivity()).itemClicked(itemPosition);
        }
    }

    public interface itemClickedInterface {
        void itemClicked(int itemPosition);
    }
}