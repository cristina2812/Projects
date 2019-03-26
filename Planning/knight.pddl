(define (domain knight)
 (:predicates (cal-at ?cal ?r ?c)
	      (next-row ?r1 ?r2)
	      (next-column ?c1 ?c2)
	      (next2-column ?ca ?cb)
	      (next2-row ?c1 ?c2))

	(:action move
		:parameters (?cal ?or ?oc ?nr ?nc)
		:precondition (and (cal-at ?cal ?or ?oc)
				   (next2-column ?oc ?nc)
				   (next-row ?or ?nr)
				   
			      )
		:effect (and (not (cal-at ?cal ?or ?oc))
			     (cal-at ?cal ?nr ?nc)
			)
	)

	(:action move1
		:parameters (?cal ?or ?oc ?nr ?nc)
		:precondition (and (cal-at ?cal ?or ?oc)
				   (next2-row ?or ?nr)
				   (next-column ?oc ?nc)
				   
			      )
		:effect (and (not (cal-at ?cal ?or ?oc))
			     (cal-at ?cal ?nr ?nc)
			)
	)
	


	
)

