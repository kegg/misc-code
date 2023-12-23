#!/usr/bin/perl
sub hello {
    print("Hello ", @_[0], "!\n");
}

&hello("World");
&hello("Sami");
&hello("Kyle");
