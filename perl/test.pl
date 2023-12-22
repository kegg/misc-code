use strict;
use Text::Template;

my $template = Text::Template->new(
    type=>'file',
    source=>'file.tmpl'
);

$Q::name = 'Fred';
$Q::age = 45;
print $Q::name;
print $Q::age;
my $text = $template->fill_in(package=>'Q');
print $text;
