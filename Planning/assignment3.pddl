(define (problem problema)
  (:domain knight)
  (:objects
     cal 
     row1 row2 row3 row4 row5 row6 row7 row8
     col1 col2 col3 col4 col5 col6 col7 col8)
  (:init
    (next-row row1 row2)          (next-column col1 col2)
    (next-row row2 row3)      	  (next-column col2 col3)
    (next-row row3 row4)      	  (next-column col3 col4)
    (next-row row4 row5)      	  (next-column col4 col5)
    (next-row row5 row6)      	  (next-column col5 col6)
    (next-row row6 row7)      	  (next-column col6 col7)
    (next-row row7 row8)      	  (next-column col7 col8)
   
    (next-row row2 row1)          (next-column col2 col1)
    (next-row row3 row2)      	  (next-column col3 col2)
    (next-row row4 row3)      	  (next-column col4 col3)
    (next-row row5 row4)      	  (next-column col5 col4)
    (next-row row6 row5)      	  (next-column col6 col5)
    (next-row row7 row6)      	  (next-column col7 col6)
    (next-row row8 row7)      	  (next-column col8 col7)
    
    (next2-row row1 row3)         (next2-column col1 col3)
    (next2-row row2 row4)      	  (next2-column col2 col4)
    (next2-row row3 row5)      	  (next2-column col3 col5)
    (next2-row row4 row6)      	  (next2-column col4 col6)
    (next2-row row5 row7)      	  (next2-column col5 col7)
    (next2-row row6 row8)      	  (next2-column col6 col8)

    (next2-row row3 row1)         (next2-column col3 col1)
    (next2-row row4 row2)      	  (next2-column col4 col2)
    (next2-row row5 row3)      	  (next2-column col5 col3)
    (next2-row row6 row4)      	  (next2-column col6 col4)
    (next2-row row7 row5)      	  (next2-column col7 col5)
    (next2-row row8 row6)      	  (next2-column col8 col6)

    (cal-at cal row1 col1)
    
)
  (:goal
   (cal-at cal row8 col8)))
