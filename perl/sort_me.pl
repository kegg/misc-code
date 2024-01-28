my @characters = qw(Picard Riker Data Troi Crusher Worf Geordi);
my @sorted = sort(@characters);

foreach (@sorted) {
    print $_."\n";
}

while ((my $index, my $value) = each @characters) {
    print $index.' '.$value."\n";
}
