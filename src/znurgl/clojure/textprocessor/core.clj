(ns znurgl.clojure.textprocessor.core)

; reading a file
(defn read-file [filename]
  (slurp filename)
  )

; removing irrelevant characters
(defn rm-irrelevant [str]
  (clojure.string/replace str #"\.|\,|\:|\n|\(|\)|\"|\\" "")    
  )

; creating a sorted list with distinct elements
(defn cr-list [str]
  (distinct
	  (sort
	    (clojure.string/split str #" ")
     )
   )
  )

; get a normalized list from file
(defn norm-file [filename]
  (cr-list
    (.toLowerCase
      (rm-irrelevant 
        (read-file filename)
        )
      )   
    ) 
  )

; START: main
(defn -main [& args]
  (norm-file "resources/test1.txt")
  )
; END: main