package net.bearfather.Scheduler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

// TODO from UCDetector: Class "JarPack" has 0 references
public class JarPack { // NO_UCD (unused code)
	public static void pack(String name,String dir) throws FileNotFoundException, IOException{
		System.out.println(dir);
		Manifest manifest = new Manifest();
		manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
		JarOutputStream target = new JarOutputStream(new FileOutputStream(name), manifest);
		add(new File(dir), target);
		target.close();
	}

	private static void add(File source, JarOutputStream target) throws IOException{
		BufferedInputStream in = null;
		try
		{
			if (source.isDirectory())
			{
				String name = source.getPath().replace("\\", "/");
				if (!name.isEmpty())
				{
					if (!name.endsWith("/"))
						name += "/";
					JarEntry entry = new JarEntry(name);
					entry.setTime(source.lastModified());
					target.putNextEntry(entry);
					target.closeEntry();
				}
				for (File nestedFile: source.listFiles())
					add(nestedFile, target);
				return;
			}
			
			JarEntry entry = new JarEntry(source.getPath().replace("\\", "/"));
			entry.setTime(source.lastModified());
			target.putNextEntry(entry);
			in = new BufferedInputStream(new FileInputStream(source));
			
			byte[] buffer = new byte[1024];
			while (true)
			{
				int count = in.read(buffer);
				if (count == -1)
					break;
				target.write(buffer, 0, count);
			}
			target.closeEntry();
		}
		finally{
			if (in != null)
				in.close();
		}
	}
	@SuppressWarnings("resource")
	public static void unPack(String name,String dir) throws java.io.IOException {
	    java.util.jar.JarFile jarfile = new java.util.jar.JarFile(new java.io.File(name));
	    java.util.Enumeration<java.util.jar.JarEntry> enu= jarfile.entries();
	    while(enu.hasMoreElements()){
	        String destdir = dir;
	        java.util.jar.JarEntry je = enu.nextElement();
	        
	        if (!je.getName().equals("META-INF/MANIFEST.MF")){
	        	java.io.File fl = new java.io.File(destdir, je.getName());
	        	if(!fl.exists()){
	        		fl.getParentFile().mkdirs();
	        		fl = new java.io.File(destdir, je.getName());
	        	}
	        	if(je.isDirectory()){
	        		continue;
	        	}
	        	java.io.InputStream is = jarfile.getInputStream(je);
	        	java.io.FileOutputStream fo = new java.io.FileOutputStream(fl);
	        	while(is.available()>0){
	        		fo.write(is.read());
	        	}
	        	fo.close();
	        	is.close();
	        }
	    }
	}
}
