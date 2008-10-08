#!/opt/local/bin/bash
#
 
#CLEAN=t PKGPACKAGE=org.texai FORKBOMB=t DEBUG=t ./tform3  RecoveryAndHowTo JSAPI_Player JabberDialogAdapter SpreadingActivation Utilities RDFEntityManager     Lexicon IncrementalFCG Inference KBMessaging    SubsumptionReasoner   BehaviorLanguage  SpeechRecognition     AlbusHierarchicalControlSystem   Dialog

#

[[ ${DEBUG:=} ]] &&  set -x 


GSED=( $( type -P  {g{,nu},s,}sed ) )
#this is the only gnu dep that seems absolutely critical for gnu extensions
 

scan_gnu (   ) ( 
 # if $1 is set we use the native leftovers, 
    cmds=(
	{{md5,sha{2{24,56},384,512}}sum,locate,logname,sh{uf,red}}
	{c{u,a}t,ls,exp{r,and},{z,tc,c,ba,}sh,mk{dir,fifo,nod,sock}}
	{cp,rm{,dir},stri{p,ngs},ln,rsync,mv,se{q,d},grep}
	{awk,tr{,ue},false,d{d,b,f,u},paste,xargs,utmp,screen}
	{read{link,elf},{u,dir,base}name,base64,find,make,head,tail}
	{join,kill{,all},m4,{,q,t}sort,{,s,w}diff,patch,unlink,yes}
	{zcat,env,dir{,colors,name},print{,f,env},who{,ami,is},pwd}
	{join,ch{root,own,mod,sh},makedep,awk,ar,ld,echo,which,wc}
	{svn,git,cvs,java{,c,p,w},jre,join,te{st,e},groups,head,vdir}
	{split,id,wait,sleep,sync}
    )

    for cmd in ${cmds[*]} 
      do
      res=( 
	  $(eval  type -P "{llvm-,gnu,g,${MACHTYPE}{-llvm,}-}${cmd}" ) 
	  ${1:+${cmd}}  
      )
      [[ ${res:=${1:+${cmd}}} ]] &&
      local ${cmd}=${res}
    done
    unset res 
    local
)
 

hoist_gnu () (
    ${GSED} -r 's,([a-z]*)=,\U\1=,g' <( scan_gnu 1)
)


terraform_terraform_mvn () { 
    ${DEBUG:+set -x}
    
    declare clause=$( ( export IFS='|' ; echo "${cmds[*]}" ) )
    
    ${GSED} <${1:-${0}} -r  "60,$ s/([^\<\{\}\,\/a-zA-Z0-9])("${clause}")([^\>\{\},\/a-zA-Z0-9])/\1"'${\U\2}\3/g'
} 


mvn_terraform () {
    mvnruntime='jaxb|jsr173_api|xerces|xml-apis|ejb|jstl|servlet'
    
    ${DEBUG:+set -x }
    ${CLEAN:+${RM} -frv pom.xml ${PKGROOT:=$(${BASENAME} $(${PWD}))}-*} 
    ${ECHO} using cmdline switches  ${M2:=mvn ${DEBUG:+-e} ${MVN_OPTS:=-B -npu } } 
    eval  PKGVER=$(svn info|grep Revision|sed -e 's,Revision: \(.*\),\1,')
    
    scm=$(
	eval   $(	    echo local tag=HEAD 
	    svn info|sed  -e 's,Repository Root: ,developerConnection=scm:svn:,' -e 's,URL: ,connection=scm:svn:,' -e 's,Revision: \(.*\),;export PKGVER=${PKGVER:=\1};,'|grep =

	)
	unset version
	
	echo "<scm>$(
	      for p in $(local)
		do
		k=${p/=*}
		v=${p/*=}
	      echo -n \<$k\>$v\</$k\>
	      done
	    )</scm>"
    )
    

# if you *MUST* regen certain modules, 
    [[ -f pom.xml ]] || {
	${M2}  -D{version=${PKGVER:=1.0-SNAPSHOT},groupId=${PKGPACKAGE:=${PKGROOT:=$(${BASENAME} $(${PWD}))}},packageName=${PKGROOT}-${PARENT:=parent},package=${PKGPACKAGE},artifactId=${PKGROOT}-${PARENT},settings.interactiveMode=false,basedir=.,packaging=pom,archetypeGroupId=${ARCHGRP:=org.apache.maven.archetypes},archetypeId=${ARCHTYPE:=maven-archetype-quickstart},archetypeVersion=${ARCHVER:=1.0},repositoryId=${ARCHREP:=internal}} archetype:generate || exit 1;
        description=${PKGROOTDESC:=${PKGROOT} Terraformed${br:="... "}by ${EMAIL:=${USER}@$(${UNAME} -n)}${br}on $(${UNAME} -i -o -p)${br}${PKGTOC:=for  $(${ECHO} ${@}|${TR} ' ' ,)${br}}}

        ${SED} -e 's,>jar<,>pom<,' -e "s~</name>~</name><description>${description}</description>~" -e "s^<url>.*</url>^<url>${PKGURL:=http://$(${UNAME} -n)}</url>$(echo ${scm})^"  ${PKGROOT}-${PARENT}/pom.xml >pom.xml
        ${RM} -fr ${PKGROOT}-${PARENT}
    };
    for i in ${@};
      do
      subdir=${PKGROOT}-${i}    
      dep2=() repo2=() plugin2=()
      composition=( $(${FIND} $i/lib -iname "*.jar" ) )
      [[  ${composition[*]} =~  openrdf  ]]  &&
#      dep2+=( 
#	  "         <dependency>"
#	  "         <groupId>org.openrdf</groupId>"
#	  "	  <artifactId>sesame</artifactId>"
#	  "	  <version>LATEST</version>"
#	  "	  </dependency><dependency>"
#	  "	  <groupId>org.openrdf</groupId>"
#	  "	  <artifactId>openrdf-model</artifactId>"
#	  "	  <version>LATEST</version>"
#	  "	  </dependency>"
#      )
#      
      
      [[ ${composition[*]} =~  aduna ]] &&   {
	  repo2+=(
	      "   <repository>"
	      "	  <releases>"
	      "	  <enabled>true</enabled>"
	      "	  <updatePolicy>always</updatePolicy>"
	      "	  <checksumPolicy>warn</checksumPolicy>"
	      "	  </releases>"
	      "	  <snapshots>"
	      "	  <enabled>false</enabled>"
	      "	  <updatePolicy>never</updatePolicy>"
	      "	  <checksumPolicy>fail</checksumPolicy>"
	      "	  </snapshots>"
	      "	  <id>aduna-repo</id>"
	      "	  <name>Aduna Repository</name>"
	      "	  <url>http://repository.aduna-software.org/maven2</url>"
	      "	  </repository>"
	      "	  <repository>"
	      "	  <releases>"
	      "	  <enabled>false</enabled>"
	      "	  <updatePolicy>never</updatePolicy>"
	      "	  <checksumPolicy>fail</checksumPolicy>"
	      "	  </releases>"
	      "	  <snapshots>"
	      "	  <enabled>true</enabled>"
	      "	  <updatePolicy>daily</updatePolicy>"
	      "	  <checksumPolicy>warn</checksumPolicy>"
	      "	  </snapshots>"
	      "	  <id>aduna-snapshot-repo</id>"
	      "	  <name>Aduna Snapshot Repository</name>"
	      "	  <url>http://repository.aduna-software.org/maven2-snapshots</url>"
	      "	  </repository>"	
	  )
#
#	  dep2+=(
#	      "    <dependency>"
#	      "    <groupId>info.aduna</groupId>"
#	      "    <artifactId>aduna</artifactId>"
#	      "    <version>2.6</version>"
#	      "    </dependency>"
#	  )
      }
      [[ ${composition[*]} =~ $mvnruntime ]] && {
	#  local archetypeId=jpa-maven-archetype
	#  local archetypeGroupId=com.rfc.maven.archetypes
	#  local archetypeVersion=1.0.0
	  dep2+=(
	      
	 #hibernate for ejb3 bloat
         #jetty for servlet bloat
         #xstream for xml bloat.
	      
	      "<dependency>"
	      "<groupId>org.hibernate</groupId>"
	      "<artifactId>hibernate-entitymanager</artifactId>"
	      "<version>3.3.2.GA</version>"
	      "</dependency>"
	      "<dependency>"
     	      "<groupId>javax.transaction</groupId>" 
	      "<artifactId>jta</artifactId>" 
	      "<version>1.0.1B</version>" 
	      "</dependency>"
	      "<dependency>"
	      "<groupId>org.mortbay.jetty</groupId>"
	      "<artifactId>jetty-management</artifactId>"
	      "<version>6.1H.8</version>"
	      "</dependency>"
	      "<dependency>"
	      "<groupId>com.thoughtworks.xstream</groupId>"
	      "<artifactId>xstream</artifactId>"
	      "<version>1.3</version>"
	      "</dependency>"
	      
	  )
      }
      [[ -f $i/nbproject/project.xml ]] &&dep2+=(
	  $(
	      ${SED} -r "s,.*>(.*)<.*,<dependency><groupId>${PKGPACKAGE}</groupId><artifactId>${PKGROOT}-\1</artifactId><version>${PKGVER}</version></dependency>," <(    ${GREP}  '<foreign-project>' $i/nbproject/project.xml)
	  )
      )
      
      ${M2} archetype:generate -D{version=${PKGVER},groupId=${PKGPACKAGE},packageName=${packageName:=${i}},package=${PKGPACKAGE}.$(${BASENAME} ${i} | ${TR} "A-Z" "a-z" ),artifactId=${subdir},settings.interactiveMode=false,basedir=.,packaging=jar,name=${i},archetypeArtifactId=${archetypeId:-maven-archetype-quickstart},archetypeGroupId=${archetypeGroupId:-org.apache.maven.archetypes},archetypeVersion=${archetypeVersion:-1.0}} || exit 1;
      unset archetypeGroupId archetypeVersion archetypeId
      description="${i} of ${PKGROOTDESC}";
      ${SED} -e "s~</name>~</name><description>${description}</description>~" -e "s^<url>.*</url>^<url>${PKGURL}/${i}</url>${scm}^" -i~ ${subdir}/pom.xml  || exit 1;
      #${MV} ${subdir}/pom.xml~ ${subdir}/pom.xml;
      [[ -d $i/src ]] && { 
	  ${RM} -fr ${subdir}/src/main/java/.
	  ${CP} -al $i/src/. ${subdir}/src/main/java/
      };
      [[ -d $i/test ]] && { 
	  ${RM} -fr ${subdir}/src/test/java/.
	  ${CP} -al $i/test/. ${subdir}/src/test/java/
      };
      [[ -d $i/test/data ]] && { 
	  ${MKDIR} -p ${subdir}/src/test/resources
	  ${CP} -al $i/test/data/. ${subdir}/src/test/resources
      };
      [[ -d $i/doc ]] && { 
	  ${MKDIR} -p src/main/resources
	  ${CP} -al $i/doc  ${subdir}/src/main/resources
      };
      [[ -d $i/data ]] && { 
	  ${MKDIR} -p src/main/resources
	  ${CP} -al $i/data/.  ${subdir}/src/main/resources
      };
      [[ -d $i/php* ]] && { 
	  ${MKDIR} -p src/main/php
	  ${CP} -al $i/php*/.  ${subdir}/src/main/php/
      };
      [[ -d $i/scripts ]] && { 
	  ${MKDIR} -p src/main/scripts
	  ${CP} -al $i/scripts/.  ${subdir}/src/main/scripts
      };
      
      [[ -d $i/repo* ]] && { 
	  ${MKDIR} -p src/main/repo
	  ${CP} -al $i/repo*   ${subdir}/src/main/resources/
      };
      [[ -d $i/lib ]] && {
	  [[ -d $i/lib/config ]] && { 
	      ${MKDIR} -p src/main/resources;
	      ${CP} -al $i/lib/config/. ${subdir}/src/main/resources
	  }
	  
	  for libfile in $(${FIND} $i/lib -iname *.jar)
	    do
	    jarfile=${libfile/*\/}
	    [[ $jarfile =~ ${mvnruntime} ]] && continue;
	    local artifactId=${jarfile/\-[0-9]*}
	    artifactId=${artifactId/.jar}
	    
	    local version=$( ${SED} -e "s,.*-\([0-9].*\)\.jar,\1," < <( ${ECHO} ${jarfile} ) )
	    version=${version/$jarfile/$PKGVER}
	    [[ ${version:=${PKGVER}} ]]
	    local groupId=$( ${SED} -e "s,\(.*\)-[^0-9].*-[0-9].*,\1," < <(${ECHO} ${jarfile} ) )
	    groupId=${groupId/$jarfile/deprecated}
	    dep2+=(
		$(echo "<dependency>"
		    for element in $( local ) 
		      do 
		      n=${element/=*}
		      v=${element/$n=}
		      ${ECHO} -e "\t<${n}>\n\t$v\n\t</$n>"
		    done
		    echo   "</dependency>" 
		)
	    )
	    [[ ${SKIPREPO} ]] || ${M2} install:install-file -D{file=${libfile},groupId=${groupId},artifactId=${artifactId},version=${version},localRepositoryId=${subdir},packaging=jar,generatePom=true,localRepositoryPath=$(${PWD})/src/main/repository}  &
	    ${DEBUG:+${WAIT}}
	  done
      }
      ${SED} "s,<dependencies>,<\!-- dependencies>," -i~ $subdir/pom.xml
      (
	  local  t=(
	      " -->"
	      "    <repositories>"
	      "    <repository>"
	      "    <i${nosplit}d>${PKGROOT}-legacy</id>"
	      "    <name>${PKGROOT}-Repo</name>"
	      "    <url>"
	      ' file://${basedir}/../src/main/repository '
	      "	   </url>"
	      "	   <layout>default</layout>"
	      "	   </repository>"
	      "	   ${repositories[@]}"
	      "	   ${repo2[@]}"
	      "	   </repositories>"
	      "	   <dependencies>"
	      "	   ${dependencies[@]}"
	      "	   ${dep2[@]}"
	      "	   </dependencies>"
	      "		  <build>"
	      "		  <plugins>"
	      "		  <plugin>"
	      "		  <groupId>org.apache.maven.plugins</groupId>"
	      "		  <artifactId>maven-compiler-plugin</artifactId>"
	      "		  <configuration>"
	      "		  <source>1.5</source>"
	      "		  <target>1.5</target>"
	      "		  <fork>true</fork>"
	      "		  <meminitial>1024m</meminitial>  "
	      "		  <maxmem>1024m</maxmem>     "
#		  "		  <compilerArguments>"
#		  "		  <!--verbose />"
#		  "		  <bootclasspath>${java.home}\lib\rt.jar</bootclasspath-->"
#		  "		  </compilerArguments>"
	      "		  </configuration>"
	      "		  </plugin>"
#		  "      <!--plugin>"
#		  "        <groupId>org.apache.maven.plugins</groupId>"
#		  "        <artifactId>maven-shade-plugin</artifactId>"
#		  "        <executions>"
#		  "          <execution>"
#		  "            <phase>package</phase>"
#		  "            <goals>"
#		  "              <goal>shade</goal>"
#		  "            </goals>"
#		  "            <configuration>"
#		  "              <artifactSet>"
#		  "                <excludes>"
#		  "                  <exclude>classworlds:classworlds</exclude>"
#		  "                  <exclude>junit:junit</exclude>"
#		  "                  <exclude>jmock:jmock</exclude>"
#		  "                  <exclude>xml-apis:xml-apis</exclude>"
#		  "                </excludes>"
#		  "              </artifactSet>"
#		  "              <transformers>"
#            '    <transformer implementation="org.apache.maven.plugins.shade.resource.ComponentsXmlResourceTransformer"/>'
#	    "              </transformers>"
#	    "            </configuration>"
#	    "          </execution>"
#	    "        </executions>"
#	    "      </plugin>"
#	    "      <plugin>"
#	    "        <groupId>org.apache.maven.plugins</groupId>"
#	    "        <artifactId>maven-source-plugin</artifactId>"
#	    "        <executions>"
#	    "          <execution>"
#	    "            <id>attach-sources</id>"
#"            <phase>verify</phase>"
#"            <goals>"
#"              <goal>jar</goal>"
#"            </goals>"
#"          </execution>"
#"        </executions>"
#"      </plugin>"
#"      <plugin>"
#"        <groupId>org.codehaus.mojo</groupId>"
#"        <artifactId>javacc-maven-plugin</artifactId>"
#"        <version>2.4.1</version>"
#"        <executions>"
#"          <execution>"
#"            <id>javacc</id>"
#"            <goals>"
#"              <goal>javacc</goal>"
#"            </goals>"
#"          </execution>"
#"        </executions>"
#"      </plugin>"
#"      <plugins>"
#"      <plugin>"
#"        <groupId>org.codehaus.mojo</groupId>"
#"        <artifactId>appassembler-maven-plugin</artifactId>"
#"        <configuration>"
#"          <programs>"
#"            <program>"
#"              <mainClass>com.mycompany.app.App</mainClass>"
#"              <name>app</name>"
#"            </program>"
#"          </programs>"
#"        </configuration>"
#"      </plugin>"
#"    </plugins>"
#"    ${plugin2[@]}"
#"      <plugin>"
#"          <groupId>org.codehaus.mojo</groupId>"
#"          <artifactId>netbeans-freeform-maven-plugin</artifactId>"
#"          <configuration>"
#"            <outputDirectory>/path/to/output/directory</outputDirectory>"
#"            <additionalGoals>plugin:xdoc site:site, projecthelp:active-profiles</additionalGoals>"
#"            <additionalFiles>src/main/mdo/FreeformProject.mdo</additionalFiles>"
#"            <additionalFolders>src/test/projects, src/site, target</additionalFolders>"
#"          </configuration>"
#"        </plugin><plugin>"
#"    <groupId>org.codehaus.mojo</groupId>"
#"    <artifactId>retrotranslator-maven-plugin</artifactId>"
#"    <executions>"
#"        <execution>"
#"            <phase>process-classes</phase>"
#"            <goals>"
#"                <goal>translate</goal>"
#"            </goals>"
#"            <configuration>"
#"                <jarfilesets>"
#"                    <jarfileset>"
#"                        <directory>${pom.basedir}/lib</directory>"
#"                        <includes>"
#"                            <include>**/*.jar</include>"
#"                        </includes>"
#"                    </jarfileset>"
#"                </jarfilesets>"
#"            </configuration>"
#"        </execution>"
#"    </executions>"
#"</plugin>" 
#"      <plugin>"
#"        <groupId>org.codehaus.mojo.webstart</groupId>"
#"        <artifactId>webstart-maven-plugin</artifactId>"
#"        <version>1.0-alpha-2</version>"
#"        <executions>"
#"          <execution>"
#"            <goals>"
#"              <goal>jnlp</goal>"
#"            </goals>"
#"          </execution>"
#"        </executions>"
#"        <configuration>"
#
#"          <d${nosplit}ependencies>"
#"            <excludes>"
#"              <exclude>commons-lang:commons-lang</exclude>"
#"            </excludes>"
#"          </dep${nosplitmeniether}endencies>"
#
#'          <resourcesDirectory>${project.basedir}/src/jnlp/resources</resourcesDirectory>'
#
#"          <jnlp>"
#"            < !-- we play with the resource path and template relative path to test MOJO-391 -- >"
#'            <inputTemplateResourcePath>${project.basedir}/src/</inputTemplateResourcePath>'
#"            <inputTemplate>jnlp/template.vm</inputTemplate>"
#"            <outputFile>test.jnlp</outputFile>"
#"            <mainClass>org.apache.commons.cli.BasicParser</mainClass>"
#"          </jnlp>"
#
#"          < !-- SIGNING -- >"
#"          < !-- defining this will automatically sign the jar and its dependencies -- >"
#"          <sign>"
#"            <keystore>/tmp/keystore</keystore>"
#"            <keypass>m2m2m2</keypass>"
#"            <storepass>m2m2m2</storepass>"
#"            < !--sigfile>m2m2m2</sigfile-- >"
#"            <alias>alias</alias>"
#"            <validity>180</validity>"
#
#"            <dnameCn>www.example.com</dnameCn>"
#"            <dnameOu>None</dnameOu>"
#"            <dnameO>ExampleOrg</dnameO>"
#"            <dnameL>Seattle</dnameL>"
#"            <dnameSt>Washington</dnameSt>"
#"            <dnameC>US</dnameC>"
#
#"            <verify>true</verify>"
#
#"            <keystoreConfig>"
#"              <delete>true</delete>"
#"              <gen>true</gen>"
#"            </keystoreConfig>"
#
#"          </sign>"
#
#"          <verbose>false</verbose>"
#"        </configuration>"
#"      </plugin>"
#"      <plugin>"
#"        <groupId>org.codehaus.mojo<groupId>"
#"        <artifactId>ianal-maven-plugin<artifactId>"
#"        <version>1.0-alpha-1-SNAPSHOT<version>"
#"      </plugin-->" 
	      "</plugins> "

" </build> "
	      "  <reporting>"
	      "    <plugins>"
	      "      <plugin>"
	      "        <groupId>org.codehaus.mojo</groupId>"
	      "        <artifactId>javacc-maven-plugin</artifactId>"
	      "        <version>2.4.1</version>"
	      "      </plugin>"
	      "    </plugins> "
	      "  </reporting>	"

	      "    </project>" 
	  )           
      ${ECHO} ${t[*]} >> $subdir/pom.xml

      type -p xmllint   && {
	  xmllint --format --output $subdir/pom.xml~  $subdir/pom.xml &&
	  VERSION_CONTROL=t ${MV} -b $subdir/pom.xml~ $subdir/pom.xml
      } # || type -p xmlformat && xmlformat -i -b~  $subdir/pom.xml  ||
	    # type -p xmlindent && xmlindent -w -t $subdir/pom.xml
      )
      
      [[ ${FORKBOMB} ]] || 
      ${WAIT} 
    done  
}

args ( ) {
    eval export    $( hoist_gnu )  
    ddel=":"=
    ${ECHO} -e -n " Usage:\n"
    par=(
	$(
	    ${SORT} -u  <(
		${GREP} -e '^[A-Z]' <(
		    ${CUT} -f 1 -d : <(
			${GREP} ${ddel} <(
			    ${TR} '{}' "\n" < ${0}
			) 
		    )
		)
	    )
	)
    )
    ( 
	export IFS='|' 
	${ECHO} "[(${par[*]})=v].. ${0} <module1..n>" 
    )
    ${ECHO} "\n\t>>>> flags for clean, debug, etc. use 't' as tru"e", all else being fals"e". "
}


[[ $@ ]] && eval  $( hoist_gnu ) mvn_terraform ${@}  && exit ||
[[ ${REWRITEME}  ]] && set +x && terraform_terraform_mvn && exit ||
[[ ${ALIASME} ]] && aliasme && exit ||
args

