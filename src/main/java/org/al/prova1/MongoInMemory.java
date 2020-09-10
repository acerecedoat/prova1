package org.al.prova1;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MongoInMemory {

//	 private int port;
//	 private String host;
//	 private MongodProcess process = null;
//
//	 public MongoInMemory(int port, String host){
//	    this.port = port;
//	    this.host = host;
//	 }
//
//	 @PostConstruct
//	 public void init() throws IOException {
//	    Storage storage = new Storage(
//	            System.getProperty("user.home") + "/.ttraining-storage", null, 0);
//
//	    IRuntimeConfig runtimeConfig = new RuntimeConfigBuilder()
//	            .defaults(Command.MongoD)
//	            .artifactStore(new ExtractedArtifactStoreBuilder()
//	                    .defaults(Command.MongoD)
//	                    .download(new DownloadConfigBuilder()
//	                            .defaultsForCommand(Command.MongoD).build())
//	                    .executableNaming(new UserTempNaming()))
//	            .build();
//
//	    IMongodConfig mongodConfig = new MongodConfigBuilder()
//	            .version(Version.Main.PRODUCTION)
//	            .net(new Net(host, port, false))
//	            .replication(storage)
//	            .build();
//
//	    MongodStarter runtime = MongodStarter.getInstance(runtimeConfig);
//	    process = runtime.prepare(mongodConfig).start();
//	 }
//
//	 @PreDestroy
//	 public void stop(){
//	    process.stop();
//	 }
	}
