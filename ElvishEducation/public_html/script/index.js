/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$( 'div.banner' ).hide();
$( '.button' ).hide();

function main() {
    $( 'div.banner' ).fadeIn( 600 );
    $( '.button' ).fadeIn( 1000 );
}

$(document).ready(main);