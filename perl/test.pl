#!/usr/bin/perl
use strict;
use warnings;
use Text::Template;

$template = Text::Template->new(
    type=>'file',
    source=>'file.tmpl'
);

$Q::name = 'Fred';
$Q::age = 45;
$text = $template->fill_in(package=>'Q');
print $text;
