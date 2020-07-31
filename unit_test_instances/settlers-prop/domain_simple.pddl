(define (domain settlers)
;(:requirements :typing :negative-preconditions :conditional-effects)
(:types
    store stone_level ore_level timber_level coal_level wood_level iron_level resource space_level housing_level - object
    place vehicle - store
    stone_atleastlevel - stone_level
    ore_atleastlevel - ore_level
    timber_atleastlevel - timber_level
    coal_atleastlevel - coal_level
    wood_atleastlevel - wood_level
    iron_atleastlevel - iron_level
)
(:constants
    spl0 spl1 spl2 spl3 spl4 spl5 spl6 spl7 spl8 spl9 spl10 - space_level
    hl0 hl1 hl2 hl3 hl4 hl5 hl6 hl7 hl8 hl9 hl10 - housing_level
    sl1 sl2 sl4 - stone_atleastlevel
    sl0 sl3 sl5 sl6 sl7 sl8 sl9 sl10 - stone_level
    ol1 ol2 ol4 - ore_atleastlevel
    ol0 ol3 ol5 ol6 ol7 ol8 ol9 ol10 - ore_level
    tl1 tl2 tl4 - timber_atleastlevel
    tl0 tl3 tl5 tl6 tl7 tl8 tl9 tl10 - timber_level
    cl1 cl2 cl4 - coal_atleastlevel
    cl0 cl3 cl5 cl6 cl7 cl8 cl9 cl10 - coal_level
    wl1 wl2 wl4 - wood_atleastlevel
    wl0 wl3 wl5 wl6 wl7 wl8 wl9 wl10 - wood_level
    il1 il2 il4 - iron_atleastlevel
    il0 il3 il5 il6 il7 il8 il9 il10 - iron_level
)
(:predicates
    (CONNECTED-BY-LAND ?p1 - place ?p2 - place)
    (connected-by-rail ?p1 - place ?p2 - place)
    (CONNECTED-BY-SEA ?p1 - place ?p2 - place)
    (BY-COAST ?p - place)
    (has-coal-stack ?p - place)
    (has-sawmill ?p - place)
    (has-ironworks ?p - place)
    (has-docks ?p - place)
    (has-wharf ?p - place)
    (potential ?v - vehicle)
    (is-cart ?v - vehicle)
    (is-train ?v - vehicle)
    (is-ship ?v - vehicle)
    (is-at ?v - vehicle ?p - place)
    (space-in ?v - vehicle ?l - space_level)
    (available-stone ?s - store ?l - stone_level)
    (available-ore ?s - store ?l - ore_level)
    (available-timber ?s - store ?l - timber_level)
    (available-coal ?s - store ?l - coal_level)
    (available-wood ?s - store ?l - wood_level)
    (available-iron ?s - store ?l - iron_level)
    (housing ?p - place ?l - housing_level)
    (DIFF-STONE ?l1 ?l2 ?l3 - stone_level)
    (DIFF-ORE ?l1 ?l2 ?l3 - ore_level)
    (DIFF-TIMBER ?l1 ?l2 ?l3 - timber_level)
    (DIFF-COAL ?l1 ?l2 ?l3 - coal_level)
    (DIFF-WOOD ?l1 ?l2 ?l3 - wood_level)
    (DIFF-IRON ?l1 ?l2 ?l3 - iron_level)
    (DIFF-SPACE ?l1 ?l2 ?l3 - space_level)
    (DIFF-HOUSING ?l1 ?l2 ?l3 - housing_level)
    (available-atleast-stone ?s - store ?l - stone_level)
    (available-atleast-ore ?s - store ?l - ore_level)
    (available-atleast-timber ?s - store ?l - timber_level)
    (available-atleast-coal ?s - store ?l - coal_level)
    (available-atleast-wood ?s - store ?l - wood_level)
    (available-atleast-iron ?s - store ?l - iron_level)
    (has-space ?v - vehicle)
    ; ?r_old < ?al <= ?rold + ?r_added
    (ADD-ATLEAST-STONE ?r_old - stone_level ?r_added - stone_atleastlevel ?al - stone_atleastlevel)
    (ADD-ATLEAST-ORE ?r_old - ore_level ?r_added - ore_atleastlevel ?al - ore_atleastlevel)
    (ADD-ATLEAST-TIMBER ?r_old - timber_level ?r_added - timber_atleastlevel ?al - timber_atleastlevel)
    (ADD-ATLEAST-COAL ?r_old - coal_level ?r_added - coal_atleastlevel ?al - coal_atleastlevel)
    (ADD-ATLEAST-WOOD ?r_old - wood_level ?r_added - wood_atleastlevel ?al - wood_atleastlevel)
    (ADD-ATLEAST-IRON ?r_old - iron_level ?r_added - iron_atleastlevel ?al - iron_atleastlevel)
    ; ?r_old - r_consumed < ?al <= ?rold
    (DEL-ATLEAST-STONE ?r_old - stone_level ?r_consumed - stone_atleastlevel ?al - stone_atleastlevel)
    (DEL-ATLEAST-ORE ?r_old - ore_level ?r_consumed - ore_atleastlevel ?al - ore_atleastlevel)
    (DEL-ATLEAST-TIMBER ?r_old - timber_level ?r_consumed - timber_atleastlevel ?al - timber_atleastlevel)
    (DEL-ATLEAST-COAL ?r_old - coal_level ?r_consumed - coal_atleastlevel ?al - coal_atleastlevel)
    (DEL-ATLEAST-WOOD ?r_old - wood_level ?r_consumed - wood_atleastlevel ?al - wood_atleastlevel)
    (DEL-ATLEAST-IRON ?r_old - iron_level ?r_consumed - iron_atleastlevel ?al - iron_atleastlevel)
)


;; B.1: Building structures.
; timber [place] -= 1
(:action build-coal-stack
    :parameters (?p - place)
    :precondition
    (and
        (not (has-coal-stack ?p))
        (available-atleast-timber ?p tl1)
    )
    :effect
    (and
        (has-coal-stack ?p)
        (forall (?told ?tnew - timber_level)
            (when
                (and
                    (available-timber ?p ?told)
                    (DIFF-TIMBER ?told tl1 ?tnew)
                )
                (and
                    (not (available-timber ?p ?told))
                    (available-timber ?p ?tnew)
                )
            )
        )
        (forall (?told - timber_level ?al - timber_atleastlevel)
            (when
                (and
                    (available-timber ?p ?told)
                    (DEL-ATLEAST-TIMBER ?told tl1 ?al)
                )
                (not (available-atleast-timber ?p ?al))
            )
        )
            
    )
)

)
