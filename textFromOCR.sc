i m p o r t   s c a l a . i o . S o u r c e  
 i m p o r t   s c a l a . x m l . _  
  
 @ m a i n  
 d e f   t e x t F r o m O c r ( f :   S t r i n g )   =   {  
  
         v a l   x m l T e x t   =   s c a l a . i o . S o u r c e . f r o m F i l e ( f ) . g e t L i n e s . m k S t r i n g  
         v a l   r o o t   =   X M L . l o a d S t r i n g ( x m l T e x t )  
         / /   T h i s   i s   t h e   p a t h   t o   w o r d   s p a n s   i n   t h e   O C R   o u t p u t :  
         v a l   w o r d S p a n s   =   r o o t \ " b o d y " \ " d i v " \ " s p a n " \ " s p a n "  
         v a l   t e x t C o n t e n t s   =   w o r d S p a n s . m a p ( _ . t e x t ) . m k S t r i n g ( "   " )  
         v a l   w d s   =   t e x t C o n t e n t s . s p l i t ( " [   ] " )  
         v a l   f i l t e r e d W o r d s   =   w d s . f i l t e r N o t ( _ . m a t c h e s ( " [ , \ \ . : A - Z a - z 0 - 9 � �] + \ \ - ? " ) ) . f i l t e r N o t ( _ . i s E m p t y )  
  
         / /   d e h y p h e n a t e :  
         v a l   f i l t e r e d T e x t   =   f i l t e r e d W o r d s . m k S t r i n g ( "   " ) . r e p l a c e A l l ( " -   " ,   " " )  
  
         v a l   s e n t e n c e s   =   f i l t e r e d T e x t . s p l i t ( " \ \ . " )  
  
         v a l   n u m b e r e d S e n t e n c e s   =   s e n t e n c e s . z i p W i t h I n d e x  
         f o r   ( s   < -   n u m b e r e d S e n t e n c e s )   {  
             p r i n t l n ( s . _ 2   +   " \ t "   +   s . _ 1   +   " . \ n " )  
         }  
  
 } 
