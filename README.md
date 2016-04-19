# popmovies

first commit

Data arrays , could not appear in the application

need to change in the content_activity
(fragment -> framelayout/relativelayout)
and 
PlaceholderFragment fragment = new PlaceholderFragment();
        ft.add(R.id.listItem, fragment);
        ft.commit();
changed to
PlaceholderFragment fragment = new PlaceholderFragment();
        ft.add(R.id.fragment, fragment);
        ft.commit();
