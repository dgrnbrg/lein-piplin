(ns leiningen.piplin)
 
(defn piplin [project command & args]
  (case command
  	"bitstream" (build project args)
  	; "verilog" nil
  	; "synthesize" (hdlmake/build project args)
  	; "program"	(flcli/program project args)
  	:else nil))
 
(defn bootstrapped? []
	(if-not (.exists (io/file ".piplin/hdlmake.py"))
		(sh "wget"
				"-P" ".piplin"
				"-q" "https://github.com/makestuff/hdlmake/blob/master/bin/hdlmake.py")))
 
(defn build [project args]
	(bootstrapped?)
	; (sh "python" ".piplin/hdlmake.py"
	; 	"-t" template
	; 	"-b" board)
	)
