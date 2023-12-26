#!/usr/bin/perl

open LOG, ">>", "file.log";

while (<>) {
    print LOG $_ . "\n";
}

close LOG;
