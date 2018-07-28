
Lion
===============



####   :tada::tada::tada: Kotlin + LiveData + ViewModel + RXJava2 + Retrofit + OKHttp + + Room + Material Design + Glide build，welcome star or fork。


Screenshots
===============

<a href="logo/lion01.png"><img src="logo/lion01.png" width="30%"/></a> 
<a href="logo/lion02.png"><img src="logo/lion02.png" width="30%"/></a> 
<a href="logo/lion03.png"><img src="logo/lion03.png" width="30%"/></a>


<a href="logo/lion04.png"><img src="logo/lion04.png" width="30%"/></a> 
<a href="logo/lion05.png"><img src="logo/lion05.png" width="30%"/></a>
<a href="logo/lion06.png"><img src="logo/lion06.png" width="30%"/></a>


Download :tada:
------
[fir - (Lion app download)](https://fir.im/lion333)


Gradle :fire:
------


[![](https://jitpack.io/v/ruzhan123/Lion.svg)](https://jitpack.io/#ruzhan123/Lion)

:heart: If you want use movie list module, Add it in your root build.gradle at the end of repositories:


```java

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

:heart: Add the dependency:


```java

	dependencies {
	        implementation 'com.github.ruzhan123.Lion:movie:0.1.6'
	}
```

:heart: Proguard
------

```java

-keep class com.ruzhan.lion.model.** { *; }
-keep class com.ruzhan.lion.db.entity.** { *; }

```


Version :sunny:
------
#### 2018-7-28    v0.1.6
*  movie module repositories, integrated room local db



Developed by :sunny:
-------

 ruzhan - <a href='javascript:'>dev19921116@gmail.com</a>


License
-------

    Copyright 2018 ruzhan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

