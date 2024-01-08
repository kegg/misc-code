#!/usr/bin/perl
print("What is your name? ");
chomp(my $name = <STDIN>);
print("How old are you? ");
chomp(my $age = <STDIN>);
print("I am $name and am $age years old\n");
