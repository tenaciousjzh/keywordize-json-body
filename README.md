# keywordize-json-body
This is expected to be added as Ring middleware that runs after ring.json.middleware/wrap-json-body. The wrap-json-body middleware does not convert map keys over to clojure based keywords. This middleware takes the result of wrap-json-body and converts the keys over to standard clojure based keywords.

## Installation
Add this to your leiningen project
```
[org.bytescale.keywordize-json-body "0.0.1"]
```

[![Clojars Project](http://clojars.org/org.bytescale.keywordize-json-body/latest-version.svg)](http://clojars.org/org.bytescale.keywordize-json-body)


## License

Copyright © 2015 Jared Holmberg

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
