# A. PRE-REQUISITES:
Run the program in java 8

# B. Example of how to run the program
To run the program:\
_sol@Breakthrough ~/Desktop/CSC3003S/Project/CODE/Capstone-Project $ make_\
_sol@Breakthrough ~/Desktop/CSC3003S/Project/CODE/Capstone-Project $ make run ARG=TestDATA_\
Note that TestData is the root directory of the digital objects


# C. METADATA TEMPLATES
General rules: \
* If you want to apply a metadata xml to a group of objects, create a new directory for the group and store the metadata in that directory.\
* If you want to apply a metadata xml to a single object, follow place the metadata xml in the same directory as the object\
* IT IS IMPORTANT NOT TO MIX GROUP APPLICATION METADATA AND SIGNLE OBJECT APPLICATION METADATA, SINCE THIS WILL LEAD TO A BUGGY SITE 
(we don't support hierarchical metadata application)

## IMAGE

#### Single Image

```xml
<?xml version="1.0" encoding="UTF-8"?>
<image>

    <name>
        <!-- name of image-->
    </name>

    <src>
        <!-- Specifies location of image with respect to the root directory (in some cases this may refer to an online image) -->
    </src>

    <title>
        <!-- Specifies title of image-->
    </title>

    <type>
        <!-- Specifies the type of image format-->
    </type>

    <alt>
        <!-- Specifies an alternate text for an image -->
    </alt>

    <width>
        <!-- Specifies width of an image -->
    </width>

    <height>
        <!-- Specifies height of an image -->
    </height>

    <size>
        <!-- Specifies the size of the image in K-->
    </size>

    <author>
        <!-- Specifies who took the image -->
    </author>

    <description>
        <!-- Describes the content of the image-->
    </description>

    <location>
        <!-- Specifies the location at which the image was taken-->
    </location>

    <date>
        <!-- Specifies the date at which the image was taken-->
    </date>

    <copyright>
        <!-- Specifies legal information about the use of the image-->
    </copyright>

</image>
```

#### GALLERY
```xml
<?xml version="1.0" encoding="UTF-8"?>
<gallery>

    <name>
        <!-- name of group of images -->
    </name>

    <src>
        <!-- Specifies location of the xml file with respect to the root directory -->
    </src>

    <author>
        <!-- Specifies who took the image -->
    </author>

    <description>
        <!-- Describes the content of the image-->
    </description>

    <location>
        <!-- Specifies the location at which the image was taken-->
    </location>

    <date>
        <!-- Specifies the date at which the image was taken-->
    </date>

    <copyright>
        <!-- Specifies legal information about the use of the image-->
    </copyright>

</gallery>
```



*  //TODO

## AUDIO
## VIDEO
## DOCUMENT