Palmetto
========
<i><b>P</b>almetto is a qu<b>al</b>ity <b>me</b>asuring <b>t</b>ool for <b>to</b>pics</i>

This is the implementation of coherence calculations for evaluating the quality of topics. If you want to learn more about coherence calculations and their meaning for topic evaluation, take a look at the <a href="http://palmetto.aksw.org/">project homepage</a> - especially at the publications.

<span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Palmetto</span> from <a xmlns:cc="http://creativecommons.org/ns#" href="http://aksw.org" property="cc:attributionName" rel="cc:attributionURL">AKSW</a> is licensed under a <a rel="license" href="http://www.gnu.org/licenses/lgpl-3.0.txt">LGPL v3.0 License</a>.

Please take a look at the the wikipage to read <a href="https://github.com/AKSW/Palmetto/wiki/How-Palmetto-can-be-used">how Palmetto can be used</a>.

If you are using Palmetto for an experiment or something similar that leads to a publication, please cite the paper "Exploring the Space of Topic Coherence Measures" that you can find on the project website. A link to the project website is welcome as well :)


### Docker

There is a web application in a separate branch (https://github.com/AKSW/Palmetto/tree/webApp) that can be executed using Docker. 

	docker build -t palmetto .
	docker run -p 7777:7777 -d -m 4G -v /path/to/indexes/:/usr/src/indexes/:ro palmetto`

After that there is a Tomcat listening on port 7777. The application can be accessed using `http://localhost:7777/palmetto-webapp/index.html`.
