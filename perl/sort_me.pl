#!/usr/bin/perl
@characters = qw(Picard Riker Data Troi Crusher Worf Geordi);
@sorted = sort(@characters);

foreach (@sorted) {
    print $_."\n";
}

while (($index, $value) = each @characters) {
    print $index.' '.$value."\n";
}
